package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: liubaojun
 * Date: 2022/8/30
 * Time: 21:47
 * Description: No Description
 */
@RestController
@Slf4j
public class OrderConsulController {
    private static final String INVOKE_IP = "http://consul-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/order/consul")
    public String orderConsul(){
        return restTemplate.getForObject(INVOKE_IP + "/payment/consul",String.class);
    }
}
