package com.whale.sell.order.domain.DTO;

import com.whale.sell.enums.OrderStatusEnum;
import com.whale.sell.enums.PayStatusEnum;
import com.whale.sell.order.domain.entity.OrderDetail;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderDTO
 * @Description TODO
 * @Author like
 * @Data 2019/3/8 19:00
 * @Version 1.0
 **/
@Data
public class OrderDTO {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Integer payStatus;

    private Date createTime;

    private Date updateTime;

    private List<OrderDetail> orderDetailList;

}
