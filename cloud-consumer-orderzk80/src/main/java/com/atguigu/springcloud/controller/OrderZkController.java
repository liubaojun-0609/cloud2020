package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: liubaojun
 * Date: 2022/8/29
 * Time: 23:21
 * Description: No Description
 */
@RestController
@Slf4j
public class OrderZkController {
    private static final String INVOKE_URL = "http://cloud-provide-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String paymentZk(){
        return restTemplate.getForObject(INVOKE_URL + "/payment/zk",String.class);
    }
}
