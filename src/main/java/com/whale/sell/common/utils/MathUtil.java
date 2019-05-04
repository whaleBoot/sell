package com.whale.sell.common.utils;

import java.util.Date;

/**
 * @ClassName MathUtil
 * @Description TODO
 * @Author like
 * @Data 2019/5/4 17:44
 * @Version 1.0
 **/

public class MathUtil {

    private static final Double MONEY_RANGE = 0.01;

    /**
     * 比较2个金额是否相等
     *
     * @param d1
     * @param d2
     * @return
     */
    public static Boolean equals(Double d1, Double d2) {
        Double result = Math.abs(d1 - d2);
        if (result < MONEY_RANGE) {
            return true;
        } else {
            return false;
        }
    }
}
