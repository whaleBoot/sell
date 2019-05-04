package com.whale.sell.pay.controller;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.rest.type.Post;
import com.whale.sell.enums.ResultEnum;
import com.whale.sell.exception.SellException;
import com.whale.sell.order.domain.DTO.OrderDTO;
import com.whale.sell.order.service.OrderService;
import com.whale.sell.pay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @ClassName PayController
 * @Description TODO
 * @Author like
 * @Data 2019/5/4 14:11
 * @Version 1.0
 **/

@Controller
@RequestMapping("/pay")
public class PayController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String,Object> map) {

        //1. 查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        PayResponse payResponse = payService.create(orderDTO);

        map.put("payResponse",payResponse);
        map.put("returnUrl",returnUrl);

        //2. 支付
        return new ModelAndView("pay/create",map);

    }

    /**
     * 微信异步通知
     * @param notifyData
     * @return
     */
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData){
        payService.notify(notifyData);

        //返回给微信处理结果
        return new ModelAndView("pay/success");


    }
}
