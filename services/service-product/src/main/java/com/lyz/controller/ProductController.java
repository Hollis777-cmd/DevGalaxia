package com.lyz.controller;

import com.lyz.dto.Result;
import com.lyz.pojo.Product;
import com.lyz.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // 添加商品
    @PostMapping("/addProduct")
    public Result addProduct(@RequestBody Product product) {
        Result result = productService.addProduct(product);
        return result;
    }

    // 删除商品
    @GetMapping("/deleteProduct/{id}")
    public Result deleteProduct(@PathVariable("id") int id) {
        Result result = productService.deleteProduct(id);
        return result;
    }

    // 修改商品
    @PostMapping("/updateProduct")
    public Result updateProduct(@RequestBody Product product) {
        Result result = productService.updateProduct(product);
        return result;
    }

    // 查询商品
    @GetMapping("/getProduct/{id}")
    public Result getProductById(@PathVariable Integer id) {
        Result result = productService.getProductById(id);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    // 查询所有商品
    @GetMapping("/getAllProducts")
    public Result getProduct() {
        Result result = productService.getProduct();
        return result;
    }
}
