package com.whale.sell.enums;

import lombok.Getter;

/**
 * @ClassName ResultEnum
 * @Description TODO
 * @Author like
 * @Data 2019/3/8 19:28
 * @Version 1.0
 **/
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品库存不正确"),
    ORDER_NOT_EXIST(12,"订单不存在"),
    ORDERDETAIL_NOT_EXIST(13,"订单详情不存在"),

    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
