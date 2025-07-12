package com.lyz;

import com.lyz.dto.Result;
import com.lyz.feign.ProductFeignClient;
import com.lyz.feign.WeatherFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WeatherTest {

    @Autowired
    WeatherFeignClient weatherFeignClient;

    @Autowired
    ProductFeignClient productFeignClient;

    @Test
    void test01() {
        String result = weatherFeignClient.getWeather("application/x-www-form-urlencoded", "苏州" ,"980e3923826dd431683593a7bc5df6a1");
        System.out.println(result);
    }

    @Test
    void test02() {
        Result result = productFeignClient.getProductById(1);
        System.out.println(result);
    }
}
