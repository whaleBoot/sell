package com.whale.sell.common.converter;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.whale.sell.enums.ResultEnum;
import com.whale.sell.exception.SellException;
import com.whale.sell.order.domain.DTO.OrderDTO;
import com.whale.sell.order.domain.VO.OrderVO;
import com.whale.sell.order.domain.entity.OrderDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OrderVO2OrderDTOConverter
 * @Description TODO
 * @Author like
 * @Data 2019/3/9 12:42
 * @Version 1.0
 **/
@Slf4j
public class OrderVO2OrderDTOConverter {

    public static OrderDTO conver(OrderVO orderVO) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderVO.getName());
        orderDTO.setBuyerPhone(orderVO.getPhone());
        orderDTO.setBuyerAddress(orderVO.getAddress());
        orderDTO.setBuyerOpenid(orderVO.getOpenid());
        Gson gson = new Gson();
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderVO.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            log.error("【对象转换】错误，String={}", orderVO.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
