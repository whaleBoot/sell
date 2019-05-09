package com.whale.sell.auth.service.impl;


import com.whale.sell.auth.domian.DTO.SellerInfoDTO;
import com.whale.sell.auth.domian.entity.SellerInfo;
import com.whale.sell.auth.repository.SellerInfoRepository;
import com.whale.sell.auth.service.SellerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
  *@ClassName SellerServiceImpl
  *@Description 卖家端
  *@Author coco
  *@Data 2019/5/5 9:36
  *@Version 1.0
  **/
@Service
@Transactional
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }

    @Override
    public SellerInfo findSellerInfoByUserNameAndPassWord(String userName, String passWord) {
        return repository.findByUsernameAndPassword(userName,passWord);
    }

    @Override
    public SellerInfo findSellerInfoByUserName(String userName) {
        return repository.findByUsername(userName);
    }
    @Override
    public SellerInfo save(SellerInfoDTO sellerInfoDTO) {
        SellerInfo sellerInfo = new SellerInfo();
        BeanUtils.copyProperties(sellerInfoDTO,sellerInfo);
        return repository.save(sellerInfo);
    }
}
