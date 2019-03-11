package com.whale.sell.product.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @ClassName ProductInfo
 * @Description 商品详情
 * @Author like
 * @Data 2019/3/8 10:35
 * @Version 1.0
 **/
@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    /** 状态 0正常 1下架. */
    private Integer productStatus;

    private Integer categoryType;
}
