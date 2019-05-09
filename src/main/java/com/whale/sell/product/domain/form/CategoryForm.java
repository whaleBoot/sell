package com.whale.sell.product.domain.form;

import lombok.Data;

/**
  *@ClassName CategoryForm
  *@Description 类目表单验证
  *@Author coco
  *@Data 2019/5/5 9:10
  *@Version 1.0
  **/
@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
