package com.whale.sell.order.repository;

import com.whale.sell.order.domain.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456789111");
        orderDetail.setOrderId("1111111111");
        orderDetail.setProductIcon("http://xxxxxxxxx.jpg");
        orderDetail.setProductName("芒果冰");
        orderDetail.setProductId("1111111111111");
        orderDetail.setProductPrice(new BigDecimal(13.2));
        orderDetail.setProductQuantity(20);

        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList =  orderDetailRepository.findByOrderId("1111111111");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}