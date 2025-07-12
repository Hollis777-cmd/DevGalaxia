package com.lyz.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.lyz.dto.OrderDTO;
import com.lyz.dto.Result;
import com.lyz.pojo.Order;

public interface OrderService extends IService<Order> {
    public Result createOrder(OrderDTO orderDTO);
}
