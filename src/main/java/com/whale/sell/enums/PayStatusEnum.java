package com.whale.sell.enums;

import lombok.Getter;

/**
 * @ClassName PayStatusEnum
 * @Description 支付状态枚举
 * @Author like
 * @Data 2019/3/8 15:53
 * @Version 1.0
 **/
@Getter
public enum PayStatusEnum implements CodeEnum<Integer> {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),;
    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
