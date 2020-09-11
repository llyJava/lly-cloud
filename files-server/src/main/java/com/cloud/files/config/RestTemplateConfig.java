package com.cloud.files.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: TODO
 * @Author luoliyin
 * @Date 2020/8/25
 **/
@Configuration
public class RestTemplateConfig {
    //在工厂中创建一个restTemplate对象
    @Bean
    @LoadBalanced //代表ribbon负载均衡的restTemplate客户端对象
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}