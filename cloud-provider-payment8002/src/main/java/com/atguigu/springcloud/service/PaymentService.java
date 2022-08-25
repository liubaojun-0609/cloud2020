package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 * User: liubaojun
 * Date: 2022/8/24
 * Time: 9:40
 * Description: No Description
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
