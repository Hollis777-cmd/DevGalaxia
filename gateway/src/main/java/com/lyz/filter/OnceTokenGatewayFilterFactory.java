//package com.lyz.filter;
//
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class OnceTokenGatewayFilterFactory extends AbstractGatewayFilterFactory<OnceTokenGatewayFilterFactory.Config> {
//
//    // 构造函数
//    public OnceTokenGatewayFilterFactory() {
//        super(Config.class);
//    }
//
//    @Override
//    public List<String> shortcutFieldOrder() {
//        return Arrays.asList("name", "value");
//    }
//
//    @Override
//    public GatewayFilter apply(Config config) {
//        return new GatewayFilter() {
//            @Override
//            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//                return chain.filter(exchange).then(Mono.fromRunnable(() -> {
//                    ServerHttpResponse response = exchange.getResponse();
//                    HttpHeaders headers = response.getHeaders();
//                    String value = config.getValue();
//                    if("jwt".equalsIgnoreCase(value)){
//                        value = "";
//                    }
//                    headers.add(config.getName(), value);
//                }));
//            }
//        };
//    }
//
//    // 配置类
//    public static class Config {
//        private String name;
//        private String value;
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getValue() {
//            return value;
//        }
//
//        public void setValue(String value) {
//            this.value = value;
//        }
//    }
//}