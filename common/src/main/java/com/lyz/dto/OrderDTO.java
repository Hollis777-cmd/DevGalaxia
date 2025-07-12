package com.lyz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class OrderDTO {
    private Integer id;
    private BigDecimal amount;
    private Integer userId;
    private String userName;
    private List<OrderItemDTO> orderItems;
}
