package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommentResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: liubaojun
 * Date: 2022/8/24
 * Time: 9:54
 * Description: No Description
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommentResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("执行插入操作，插入结果ID：" + result);
        if (result > 0){
            return new CommentResult(200,"新增记录成功；serverPort：" + serverPort,result);
        }else {
            return new CommentResult(444,"新增记录失败；serverPort：" + serverPort,null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommentResult getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("查询结果为：" + paymentById);
        if(paymentById != null){
            return new CommentResult(200,"查询成功；serverPort：" + serverPort,paymentById);
        }else {
            return new CommentResult(444,"根据ID：" + id + "查询结果为空；serverPort：" + serverPort,null);
        }
    }
}
