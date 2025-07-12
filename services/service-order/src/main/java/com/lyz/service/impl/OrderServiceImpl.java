package com.lyz.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyz.dto.OrderDTO;
import com.lyz.dto.OrderItemDTO;
import com.lyz.dto.Result;
import com.lyz.feign.ProductFeignClient;
import com.lyz.mapper.OrderItemMapper;
import com.lyz.mapper.OrderMapper;
import com.lyz.pojo.Order;
import com.lyz.pojo.OrderItem;
import com.lyz.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private ProductFeignClient productFeignClient;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @SentinelResource(value = "createOrder")
    @Override
    public Result createOrder(OrderDTO orderDTO) {

        Order order = new Order();
        BeanUtils.copyProperties(orderDTO, order);
        boolean flag1 = this.save(order);

        Integer orderId = order.getId();
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemDTO itemDTO : orderDTO.getOrderItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(orderId);
            orderItem.setProductId(itemDTO.getProductId());
            orderItems.add(orderItem);
            Result res = productFeignClient.getProductById(orderItem.getProductId());
            System.out.println(res);
        }
        boolean flag2 = orderItemMapper.insertBatch(orderItems);

        if (flag1 && flag2) {
            return new Result(200, "订单创建成功", orderId);
        } else {
            return new Result(201, "订单创建失败", null);
        }
    }
}
