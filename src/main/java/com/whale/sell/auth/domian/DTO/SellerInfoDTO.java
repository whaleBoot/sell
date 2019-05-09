package com.whale.sell.auth.domian.DTO;

import lombok.Data;

/**
 * @ClassName SellerInfoDTO
 * @Description TODO
 * @Author like
 * @Data 2019/5/5 23:09
 * @Version 1.0
 **/
@Data
public class SellerInfoDTO {

    private String id;

    private String username;

    private String password;

    private String openid = "";
}
