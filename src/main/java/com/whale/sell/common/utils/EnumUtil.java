package com.whale.sell.common.utils;

import com.whale.sell.enums.CodeEnum;

/**
 * @ClassName EnumUtil
 * @Description TODO
 * @Author like
 * @Data 2019/5/4 19:00
 * @Version 1.0
 **/

public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
