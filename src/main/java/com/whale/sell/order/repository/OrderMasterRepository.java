package com.whale.sell.order.repository;

import com.whale.sell.order.domain.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName OrderMasterRepository
 * @Description 主订单dao
 * @Author like
 * @Data 2019/3/8 15:51
 * @Version 1.0
 **/
@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {


    /**
     * 根据买家openid分页查询
     * @param buyerOpenid openid
     * @param pageable 分页
     * @return 主订单
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);

    OrderMaster findByOrderId(String orderId);

}
