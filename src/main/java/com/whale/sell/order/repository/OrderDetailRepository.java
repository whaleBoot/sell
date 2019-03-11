package com.whale.sell.order.repository;

import com.whale.sell.order.domain.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName OrderDetailRepository
 * @Description 订单详情dao
 * @Author like
 * @Data 2019/3/8 16:47
 * @Version 1.0
 **/
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}
