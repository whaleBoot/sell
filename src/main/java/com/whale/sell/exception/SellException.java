package com.whale.sell.exception;

import com.whale.sell.enums.ResultEnum;

/**
 * @ClassName SellException
 * @Description TODO
 * @Author like
 * @Data 2019/3/8 19:27
 * @Version 1.0
 **/
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
