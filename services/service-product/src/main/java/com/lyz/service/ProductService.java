package com.lyz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyz.dto.Result;
import com.lyz.pojo.Product;

public interface ProductService extends IService<Product> {
    public Result addProduct(Product product);
    public Result deleteProduct(Integer id);
    public Result updateProduct(Product product);
    public Result getProductById(Integer id);
    public Result getProduct();
}
