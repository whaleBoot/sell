package com.whale.sell.common.VO;

import lombok.Data;

/**
 * @ClassName ResultVO
 * @Description http返回的最外层对象
 * @Author like
 * @Data 2019/3/8 11:35
 * @Version 1.0
 **/
@Data
public class ResultVO<T> {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;
}
