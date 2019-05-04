package com.whale.sell.pay.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;
import com.whale.sell.order.domain.DTO.OrderDTO;
import org.springframework.core.annotation.Order;

/**
 * @ClassName PayService
 * @Description TODO
 * @Author like
 * @Data 2019/5/4 14:15
 * @Version 1.0
 **/

public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);
}
