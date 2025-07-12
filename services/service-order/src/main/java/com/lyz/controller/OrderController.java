package com.lyz.controller;


import com.lyz.dto.OrderDTO;
import com.lyz.dto.Result;
import com.lyz.pojo.Order;
import com.lyz.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RefreshScope// 动态刷新
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${order.timeout}")
    private String orderTimeout;
    @Value("${order.auto-confirm}")
    private String orderAutoConfig;

    @GetMapping("/getConfig")
    public String getConfig() {
        return orderTimeout+","+orderAutoConfig;
    }

    @PostMapping("/createOrder")
    public Result createOrder(@RequestBody OrderDTO orderDTO) {
        Result result = orderService.createOrder(orderDTO);
        return result;
    }
}
