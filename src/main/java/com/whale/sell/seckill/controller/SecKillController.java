package com.whale.sell.seckill.controller;

import com.whale.sell.seckill.service.SecKillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SecKillController
 * @Description 秒杀controller
 * @Author like
 * @Data 2019/5/11 9:28
 * @Version 1.0
 **/
@RestController
@RequestMapping("/skill")
@Slf4j
public class SecKillController {

    @Autowired
    private SecKillService secKillService;

    /**
     * 查询秒杀活动特价商品的信息
     *
     * @param productId 商品id
     * @return 商品信息
     */
    @GetMapping("/query/{productId}")
    public String query(@PathVariable String productId) throws Exception {
        return secKillService.querySecKillProductInfo(productId);
    }

    /**
     * 秒杀
     *
     * @param productId 商品id
     * @return 没有抢到获得"哎呦喂,xxx",抢到了会返回剩余的库存量
     * @throws Exception 异常
     */
    @GetMapping("/order/{productId}")
    public String skill(@PathVariable String productId) throws Exception {
        log.info("@skill request, productId:" + productId);
        secKillService.orderProductMockDiffUser(productId);
        return secKillService.querySecKillProductInfo(productId);
    }

}
