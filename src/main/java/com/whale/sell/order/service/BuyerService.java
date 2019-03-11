package com.whale.sell.order.service;

import com.whale.sell.order.domain.DTO.OrderDTO;

/**
 * @ClassName BuyerService
 * @Description TODO
 * @Author like
 * @Data 2019/3/9 15:08
 * @Version 1.0
 **/

public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);


    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
