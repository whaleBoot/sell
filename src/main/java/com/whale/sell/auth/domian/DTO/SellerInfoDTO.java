package com.whale.sell.auth.domian.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName SellerInfoDTO
 * @Description TODO
 * @Author like
 * @Data 2019/5/5 23:09
 * @Version 1.0
 **/
@Data
public class SellerInfoDTO implements Serializable {

    private static final long serialVersionUID = 7513864802937087630L;

    private String id;

    private String username;

    private String password;

    private String openid = "";
}
