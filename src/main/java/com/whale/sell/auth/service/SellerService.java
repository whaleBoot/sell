package com.whale.sell.auth.service;


import com.whale.sell.auth.domian.DTO.SellerInfoDTO;
import com.whale.sell.auth.domian.entity.SellerInfo;

/**
  *@ClassName SellerService
  *@Description 卖家端
  *@Author coco
  *@Data 2019/5/5 9:36
  *@Version 1.0
  **/
public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);

    /**
     * 通过用户名密码查询卖家端信息
     * @param userName
     * @param passWord
     * @return
     */
    SellerInfo findSellerInfoByUserNameAndPassWord(String userName,String passWord);

    /**
     * 保存卖家信息
     * @param sellerInfoDTO
     * @return
     */
    SellerInfo save(SellerInfoDTO sellerInfoDTO);

    SellerInfo findSellerInfoByUserName(String userName);
}
