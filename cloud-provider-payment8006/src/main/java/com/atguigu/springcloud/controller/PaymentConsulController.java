package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: liubaojun
 * Date: 2022/8/30
 * Time: 21:32
 * Description: No Description
 */
@RestController
@Slf4j
public class PaymentConsulController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul")
    public String paymentConsul(){
        return "SpringCloud with Consul " + serverPort + "\t" + UUID.randomUUID();
    }
}
