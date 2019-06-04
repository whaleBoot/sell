package com.whale.sell.common.utils;

import com.whale.sell.common.VO.ResultVO;

/**
 * @ClassName ResultVOUtil
 * @Description 返回json工具类
 * @Author like
 * @Data 2019/3/8 15:12
 * @Version 1.0
 **/

public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success() {

        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        resultVO.setData(null);
        return resultVO;

    }
}

