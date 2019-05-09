package com.whale.sell.exception;

import lombok.Data;

/**
 * @ClassName ResponseBankException
 * @Description TODO
 * @Author like
 * @Data 2019/5/5 11:44
 * @Version 1.0
 **/
@Data
public class ResponseBankException extends RuntimeException {

    private Integer code;

}
