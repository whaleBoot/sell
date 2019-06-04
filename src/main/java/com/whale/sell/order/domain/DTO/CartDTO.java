package com.whale.sell.order.domain.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName CartDTO
 * @Description 购物车
 * @Author like
 * @Data 2019/3/8 19:49
 * @Version 1.0
 **/
@Data
public class CartDTO implements Serializable {

    private static final long serialVersionUID = -8175745711940324140L;

    private String productId;

    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
