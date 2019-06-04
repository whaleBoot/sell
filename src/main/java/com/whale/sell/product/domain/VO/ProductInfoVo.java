package com.whale.sell.product.domain.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName ProductInfoVo
 * @Description 商品详情
 * @Author like
 * @Data 2019/3/8 14:25
 * @Version 1.0
 **/
@Data
public class ProductInfoVo implements Serializable {

    private static final long serialVersionUID = -3141448936858963814L;

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
