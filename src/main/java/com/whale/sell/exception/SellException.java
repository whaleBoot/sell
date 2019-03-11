package com.whale.sell.exception;

import com.whale.sell.enums.ResultEnum;

/**
 * @ClassName SellException
 * @Description 自定义异常
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

    public SellException(Integer code, String message) {
        super(message);
         this.code = code;
    }
}
