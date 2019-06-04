package com.whale.sell.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
  *@ClassName JsonUtil
  *@Description Json工具类
  *@Author coco
  *@Data 2019/5/12 17:15
  *@Version 1.0
  **/
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
