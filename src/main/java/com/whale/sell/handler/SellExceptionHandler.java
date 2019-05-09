package com.whale.sell.handler;

import com.whale.sell.common.VO.ResultVO;
import com.whale.sell.common.config.ProjectUrlConfig;
import com.whale.sell.common.utils.ResultVOUtil;
import com.whale.sell.exception.ResponseBankException;
import com.whale.sell.exception.SellException;
import com.whale.sell.exception.SellerAuthorizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName SellExceptionHandler
 * @Description 异常捕获
 * @Author coco
 * @Data 2019/5/5 10:18
 * @Version 1.0
 **/
@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //拦截登录异常
    //http://whale.natapp1.cc/sell/wechat/qrAuthorize?returnUrl=http://whale.natapp1.cc/sell/seller/login
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect:"
                .concat(projectUrlConfig.getSell())
                .concat("/sell/seller/toLogin"));
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handleSellException(SellException e) {
        return ResultVOUtil.error(e.getCode(), e.getMessage());

    }

    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ResultVO handleResponseBankException(ResponseBankException e) {

        return ResultVOUtil.error(e.getCode(), e.getMessage());

    }
}
