package com.whale.sell.product.repository;

import com.whale.sell.product.domain.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName ProductInfoRepository
 * @Description 商品详情dao
 * @Author like
 * @Data 2019/3/8 10:47
 * @Version 1.0
 **/
@Repository
public interface ProductInfoRepository  extends JpaRepository<ProductInfo,String> {

    ProductInfo findByProductId(String productId);

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
