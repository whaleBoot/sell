package com.whale.sell.order.service;

import com.whale.sell.order.domain.DTO.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @ClassName OrderService
 * @Description 订单
 * @Author like
 * @Data 2019/3/8 18:49
 * @Version 1.0
 **/

public interface OrderService {

    /**
     * 创建订单.
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 查询单个订单.
     */
    OrderDTO findOne(String orderId);

    /**
     * 查询订单列表.
     */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**
     * 取消订单.
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 完结订单.
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 支付订单.
     */
    OrderDTO paid(OrderDTO orderDTO);

    /**
     * 查询订单列表
     * @param pageable
     * @return
     */
    Page<OrderDTO> findList(Pageable pageable);


}
