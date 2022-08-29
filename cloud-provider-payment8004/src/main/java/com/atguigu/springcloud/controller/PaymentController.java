package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: liubaojun
 * Date: 2022/8/29
 * Time: 22:43
 * Description: No Description
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/zk")
    public String paymentZk(){
        return "SpringCloud with zookeeper " + "\t" + serverPort + "\t" +UUID.randomUUID();
    }

}
