package com.lyz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyz.pojo.OrderItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {
    @Insert("<script>" +
            "INSERT INTO order_product (order_id, product_id) " +
            "VALUES " +
            "<foreach collection='list' item='item' separator=','>" +
            "(#{item.orderId}, #{item.productId})" +
            "</foreach>" +
            "</script>")
    boolean insertBatch(@Param("list") List<OrderItem> orderItems);
}
