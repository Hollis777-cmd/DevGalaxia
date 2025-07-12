package com.lyz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyz.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
