package com.whale.sell.common.constant;

/**
  *@ClassName RedisConstant
  *@Description redis常量
  *@Author coco
  *@Data 2019/5/5 9:54
  *@Version 1.0
  **/
public interface RedisConstant {

    String TOKEN_PREFIX = "token_%s";

    Integer EXPIRE = 7200; //2小时
}
