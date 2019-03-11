package com.whale.sell.enums;

import lombok.Getter;

/**
 * @ClassName ProductStatusEnum
 * @Description 商品状态枚举类
 * @Author like
 * @Data 2019/3/8 11:09
 * @Version 1.0
 **/
@Getter
public enum ProductStatusEnum {
    UP(0,"在架"),
    DOWN(1,"下架")
    ;
    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
