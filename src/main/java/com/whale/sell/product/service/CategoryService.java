package com.whale.sell.product.service;

import com.whale.sell.product.domain.entity.ProductCategory;

import java.util.List;

/**
 * @ClassName CategoryService
 * @Description TODO
 * @Author like
 * @Data 2019/3/8 10:06
 * @Version 1.0
 **/

public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
