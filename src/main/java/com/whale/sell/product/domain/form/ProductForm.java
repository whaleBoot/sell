package com.whale.sell.product.domain.form;

import lombok.Data;

import java.math.BigDecimal;

/**
  *@ClassName ProductForm
  *@Description 商品info表单验证
  *@Author coco
  *@Data 2019/5/5 9:10
  *@Version 1.0
  **/
@Data
public class ProductForm {


    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 类目编号. */
    private Integer categoryType;
}
