package com.whale.sell.seckill.service;

/**
 * @ClassName SecKillService
 * @Description TODO
 * @Author like
 * @Data 2019/5/11 9:31
 * @Version 1.0
 **/

public interface SecKillService {

    String querySecKillProductInfo(String productId);

    void orderProductMockDiffUser(String productId);

}
