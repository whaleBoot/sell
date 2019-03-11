package com.whale.sell.enums;

import lombok.Getter;

/**
 * @ClassName OrderStatusEnum
 * @Description 订单状态枚举类
 * @Author like
 * @Data 2019/3/8 15:53
 * @Version 1.0
 **/
@Getter
public enum OrderStatusEnum {

    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "取消"),;

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
