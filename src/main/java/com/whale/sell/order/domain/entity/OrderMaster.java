package com.whale.sell.order.domain.entity;

import com.whale.sell.enums.OrderStatusEnum;
import com.whale.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderMaster
 * @Description 主订单
 * @Author like
 * @Data 2019/3/8 15:47
 * @Version 1.0
 **/
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Timestamp createTime;

    private Timestamp updateTime;
}
