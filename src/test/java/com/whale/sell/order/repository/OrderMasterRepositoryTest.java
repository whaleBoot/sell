package com.whale.sell.order.repository;

import com.whale.sell.order.domain.entity.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    private final String OPENID="110110";

    @Autowired
    private OrderMasterRepository orderMasterRepository;


    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("工程师");
        orderMaster.setBuyerPhone("12345678901");
        orderMaster.setBuyerAddress("山东交通学院");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(20.8));
        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest request = PageRequest.of(0,10);
        Page<OrderMaster> orderMasterPage =  orderMasterRepository.findByBuyerOpenid(OPENID,request);
        Assert.assertNotEquals(0,orderMasterPage.getTotalElements());
    }
}