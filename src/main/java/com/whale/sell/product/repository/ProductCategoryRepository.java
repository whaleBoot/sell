package com.whale.sell.product.repository;

import com.whale.sell.product.domain.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName ProductCategoryRepository
 * @Description 商品类目dao
 * @Author like
 * @Data 2019/3/8 9:00
 * @Version 1.0
 **/
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    /**
     * 通过类目id查询
     * @param categoryId 类目id
     * @return 类目
     */
    ProductCategory findByCategoryId(Integer categoryId);

    /**
     *
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);



}
