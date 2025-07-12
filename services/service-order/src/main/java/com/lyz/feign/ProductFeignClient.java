package com.lyz.feign;

import com.lyz.dto.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "service-product")// feign客户端
public interface ProductFeignClient {

    @GetMapping("/product/getProduct/{id}")
//    public void getProductById(@PathVariable Integer id, @RequestHeader String taken);
    public Result getProductById(@PathVariable Integer id);

    @GetMapping("/product/getAllProducts")
    public Result getProduct();
}
