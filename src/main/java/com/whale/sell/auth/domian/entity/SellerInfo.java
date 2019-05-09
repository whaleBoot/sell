package com.whale.sell.auth.domian.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
  *@ClassName SellerInfo
  *@Description 卖家信息表
  *@Author coco
  *@Data 2019/5/5 9:34
  *@Version 1.0
  **/
@Data
@Entity
public class SellerInfo {

    @Id
    private String id;

    private String username;

    private String password;

    private String openid;
}
