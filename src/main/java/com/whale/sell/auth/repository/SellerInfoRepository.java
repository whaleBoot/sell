package com.whale.sell.auth.repository;

import com.lly835.bestpay.rest.type.Post;
import com.whale.sell.auth.domian.entity.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * @ClassName SellerInfoRepository
 * @Description 卖家用户信息dao
 * @Author coco
 * @Data 2019/5/5 9:34
 * @Version 1.0
 **/
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);

    SellerInfo findByUsername(String username);

    SellerInfo findByUsernameAndPassword(String username, String password);
}
