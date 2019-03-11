package com.whale.sell.order.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @ClassName OrderDetail
 * @Description 订单详情
 * @Author like
 * @Data 2019/3/8 16:43
 * @Version 1.0
 **/

@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    private String orderId;

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private String productIcon;
}
