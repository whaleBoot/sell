package com.whale.sell.product.domain.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName ProductVO
 * @Description 商品包含类目
 * @Author like
 * @Data 2019/3/8 11:43
 * @Version 1.0
 **/
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = -5762500587333385177L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;
}
