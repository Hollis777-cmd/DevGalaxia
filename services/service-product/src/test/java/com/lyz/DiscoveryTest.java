package com.lyz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@SpringBootTest// 测试类和被测试类的包名和类名要一致
public class DiscoveryTest {

    @Autowired
    DiscoveryClient discoveryClient;

    @Test
    void discoveryClientTest() {
        // 获取ip+port
        for (String serviceId : discoveryClient.getServices()) {
            System.out.println(serviceId);
            // 获取实例
            List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
            for (ServiceInstance instance : instances) {
                System.out.println("ip:"+instance.getHost());
                System.out.println("port:"+instance.getPort());
            }
        }
    }
}
