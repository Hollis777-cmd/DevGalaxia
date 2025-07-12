package com.lyz.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "weather-client", url = "https://apis.juhe.cn")
public interface WeatherFeignClient {
    @GetMapping("/simpleWeather/query")
    String getWeather(@RequestHeader("Content-Type") String contentType, @RequestParam("city") String city, @RequestParam("key") String key);
}
