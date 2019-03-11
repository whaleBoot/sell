package com.whale.sell.order.domain.VO;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

/**
 * @ClassName OrderVO
 * @Description TODO
 * @Author like
 * @Data 2019/3/9 12:32
 * @Version 1.0
 **/

@Data
public class OrderVO {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 买家手机号
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 地址必填
     */
    @NotEmpty(message = "地址必填")
    private String address;

    @NotEmpty(message = "openid必填")
    private String openid;

    @NotEmpty(message = "购物车不能为空")
    private String items;
}
