package com.lyz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("service_order")
public class Order {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private BigDecimal amount;
    @TableField("user_id")
    private Integer userId;
    @TableField("user_name")
    private String userName;
}
