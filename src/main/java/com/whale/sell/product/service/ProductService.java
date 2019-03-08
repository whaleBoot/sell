package com.whale.sell.product.service;

import com.whale.sell.product.domain.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @ClassName ProductService
 * @Description TODO
 * @Author like
 * @Data 2019/3/8 10:56
 * @Version 1.0
 **/

public interface ProductService {

    ProductInfo findOne(String productId);

    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    ProductInfo save(ProductInfo productInfo);

    //加库存

    //减库存
}
