package com.whale.sell.order.controller;

import com.whale.sell.common.VO.ResultVO;
import com.whale.sell.common.utils.ResultVOUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BuyerOrderController
 * @Description TODO
 * @Author like
 * @Data 2019/3/8 19:18
 * @Version 1.0
 **/
@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {

    @PostMapping("create")
    public ResultVO create(){

        return ResultVOUtil.success();
    }
}
