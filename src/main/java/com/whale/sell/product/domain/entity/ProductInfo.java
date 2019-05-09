package com.whale.sell.product.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.whale.sell.common.utils.EnumUtil;
import com.whale.sell.enums.ProductStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName ProductInfo
 * @Description 商品详情
 * @Author like
 * @Data 2019/3/8 10:35
 * @Version 1.0
 **/
@Entity
@DynamicUpdate
@Data
public class ProductInfo {

    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    /**
     * 状态 0正常 1下架.
     */
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /**
     * 类目编号.
     */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }


}
