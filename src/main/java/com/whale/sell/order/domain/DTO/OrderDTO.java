package com.whale.sell.order.domain.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.whale.sell.common.serializer.Date2LongSerializer;
import com.whale.sell.common.utils.EnumUtil;
import com.whale.sell.enums.OrderStatusEnum;
import com.whale.sell.enums.PayStatusEnum;
import com.whale.sell.order.domain.entity.OrderDetail;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderDTO
 * @Description 类OrderMaster
 * @Author like
 * @Data 2019/3/8 19:00
 * @Version 1.0
 **/
@Data
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 4240541709686616959L;

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Integer payStatus;


    @JsonSerialize(using = Date2LongSerializer.class)
    private Timestamp createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Timestamp updateTime;

    private List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }

}
