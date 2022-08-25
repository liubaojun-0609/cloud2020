package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: liubaojun
 * Date: 2022/8/24
 * Time: 15:33
 * Description: No Description
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced   //Ribbon 的负载均衡   默认轮询策略
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
