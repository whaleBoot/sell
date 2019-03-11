package com.whale.sell.common.utils;

import java.util.Random;

/**
 * @ClassName KeyUtil
 * @Description 生成数据库key工具类
 * @Author like
 * @Data 2019/3/8 19:38
 * @Version 1.0
 **/

public class KeyUtil {

    /**
     * 生成唯一主键
     *
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);

    }
}
