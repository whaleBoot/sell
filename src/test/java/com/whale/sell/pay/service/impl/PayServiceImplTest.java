package com.whale.sell.pay.service.impl;

import com.whale.sell.order.domain.DTO.OrderDTO;
import com.whale.sell.order.service.OrderService;
import com.whale.sell.pay.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1556679964658906967");
        payService.create(orderDTO);
    }

//    @Test
//    public void refund() {
//        OrderDTO orderDTO = orderService.findOne("1499592887470659070");
//        payService.refund(orderDTO);
//    }
}