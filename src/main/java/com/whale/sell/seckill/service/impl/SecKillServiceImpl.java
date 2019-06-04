package com.whale.sell.seckill.service.impl;

import com.whale.sell.common.utils.KeyUtil;
import com.whale.sell.exception.SellException;
import com.whale.sell.seckill.service.RedisLock;
import com.whale.sell.seckill.service.SecKillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SecKillService
 * @Description TODO
 * @Author like
 * @Data 2019/5/11 9:33
 * @Version 1.0
 **/
@Service
public class SecKillServiceImpl implements SecKillService {

    private static final int TIMEOUT = 10 * 1000; //超时时间 10s


    @Autowired
    private RedisLock redisLock;

    /**
     * 秒杀活动，皮蛋粥特价，限量100000份
     */
    static Map<String, Integer> products;
    static Map<String, Integer> stock;
    static Map<String, String> orders;

    {
        /**
         * 模拟多个表，商品信息表，库存表，秒杀成功订单表
         */
        products = new HashMap<>();
        stock = new HashMap<>();
        products.put("123456", 100000);
        stock.put("123456", 100000);
    }

    private String querMap(String productId) {
        return "秒杀活动，皮蛋粥特价，限量份"
                + products.get(productId)
                + " 还剩：" + stock.get(productId) + " 份"
                + " 该商品成功下单用户数目："
                + orders.size() + " 人";
    }

    @Override
    public String querySecKillProductInfo(String productId) {
        return this.querMap(productId);
    }

    @Override
    public void orderProductMockDiffUser(String productId) {

        //加锁
        long time = System.currentTimeMillis() + TIMEOUT;
        if (!redisLock.lock(productId, String.valueOf(time))) {
            throw new SellException(101, "哎呦喂，人也太多了，换个姿势再试试~~");
        }

        //1. 查询该商品库存，为0则表示活动结束
        int stockNum = stock.get(productId);
        if (stockNum == 0) {
            throw new SellException(100, "活动结束");
        } else {
            //2. 下单（模拟不同用户opeid不同）
            orders.put(KeyUtil.genUniqueKey(), productId);
            //3. 减库存
            stockNum = stockNum - 1;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stock.put(productId, stockNum);
        }

        //解锁
        redisLock.unlock(productId, String.valueOf(time));

    }
}
