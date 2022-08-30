package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommentResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: liubaojun
 * Date: 2022/8/24
 * Time: 15:29
 * Description: No Description
 */
@RestController
@Slf4j
public class OrderController {
//    private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://cloud-payment-service";   //集群方式访问  通过application-name
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommentResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,CommentResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommentResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,CommentResult.class);
    }

    @GetMapping(value = "/consumer/payment/getForEntity/{id}")
    public CommentResult<Payment> getPaymentById2(@PathVariable("id") Long id){
        ResponseEntity<CommentResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommentResult.class);
        if(forEntity.getStatusCode().is2xxSuccessful()){
            log.info(forEntity.getStatusCode() + "\t" + forEntity.getStatusCodeValue() + "\t" + forEntity.getHeaders());
            return forEntity.getBody();
        }else {
            return new CommentResult<>(444,"查询失败");
        }
    }

    @GetMapping(value = "/consumer/payment/createByEntity")
    public CommentResult<Payment> create2(Payment payment){
        ResponseEntity<CommentResult> forEntity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommentResult.class);
        if(forEntity.getStatusCode().is2xxSuccessful()){
            log.info(forEntity.getStatusCode() + "\t" + forEntity.getStatusCodeValue() + "\t" + forEntity.getHeaders());
            return forEntity.getBody();
        }else {
            return new CommentResult<>(444,"查询失败");
        }
    }

}
