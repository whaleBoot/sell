package com.whale.sell.order.service;


import com.whale.sell.order.domain.DTO.OrderDTO;

/**
  *@ClassName PushMessageService
  *@Description 推送消息
  *@Author coco
  *@Data 2019/5/5 10:53
  *@Version 1.0
  **/
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
