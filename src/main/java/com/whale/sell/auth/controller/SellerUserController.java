package com.whale.sell.auth.controller;


import com.lly835.bestpay.rest.type.Post;
import com.whale.sell.auth.domian.DTO.SellerInfoDTO;
import com.whale.sell.auth.domian.entity.SellerInfo;
import com.whale.sell.auth.service.SellerService;
import com.whale.sell.common.VO.ResultVO;
import com.whale.sell.common.config.ProjectUrlConfig;
import com.whale.sell.common.constant.CookieConstant;
import com.whale.sell.common.constant.RedisConstant;
import com.whale.sell.common.utils.CookieUtil;
import com.whale.sell.common.utils.KeyUtil;
import com.whale.sell.common.utils.MD5Tools;
import com.whale.sell.common.utils.ResultVOUtil;
import com.whale.sell.enums.ResultEnum;
import com.whale.sell.exception.SellException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
  *@ClassName SellerUserController
  *@Description 卖家端controller
  *@Author coco
  *@Data 2019/5/12 17:15
  *@Version 1.0
  **/
@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid,
                              HttpServletResponse response,
                              Map<String, Object> map) {

        //1. openid去和数据库里的数据匹配
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openid);
        if (sellerInfo == null) {
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error");
        }

        //2. 设置token至redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;

        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), openid, expire, TimeUnit.SECONDS);

        //3. 设置token至cookie
        CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.EXPIRE);

        return new ModelAndView("redirect:" + projectUrlConfig.getSell() + "/sell/seller/order/list");

    }

    @GetMapping("/toLogin")
    public ModelAndView toLogin() {
        return new ModelAndView("auth/login");
    }

    @GetMapping("/generalLogin")
    public ModelAndView generalLogin(@RequestParam("userName") String userName,
                                     @RequestParam("passWord") String password,
                                     HttpServletResponse response,
                                     Map<String, Object> map) {

        //1. 根据openid去和数据库里的数据匹配
        SellerInfo sellerInfo = sellerService.findSellerInfoByUserName(userName);
        if (sellerInfo == null) {
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error");
        }
        if(!MD5Tools.verify(password,sellerInfo.getPassword())){
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error");
        }

        //2. 设置token至redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;

        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token),
                userName, expire, TimeUnit.SECONDS);

        //3. 设置token至cookie
        CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.EXPIRE);

        return new ModelAndView("redirect:" + projectUrlConfig.getSell() + "/sell/seller/order/list");

    }


    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                               HttpServletResponse response,
                               Map<String, Object> map) {
        //1. 从cookie里查询
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null) {
            //2. 清除redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));

            //3. 清除cookie
            CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
        }

        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }


    @PostMapping("/register")
    @ResponseBody
    public ResultVO register(@RequestParam("userName") String userName,
                             @RequestParam("passWord") String password) {

        if (StringUtils.isEmpty(userName)) {
            throw new SellException(ResultEnum.USERNAME_NOT_EMPTY);
        }

        if (StringUtils.isEmpty(password)) {
            throw new SellException(ResultEnum.PASSWORD_NOT_EMPTY);
        }

        SellerInfo sellerInfo = sellerService.findSellerInfoByUserName(userName);

        if(sellerInfo!=null){
            throw new SellException(ResultEnum.SELLER_IS_EXISt);
        }

        SellerInfoDTO sellerInfoDTO = new SellerInfoDTO();
        sellerInfoDTO.setId(KeyUtil.genUniqueKey());
        sellerInfoDTO.setUsername(userName);
        sellerInfoDTO.setPassword(MD5Tools.generate(password));
        try {
            sellerService.save(sellerInfoDTO);
        } catch (Exception e) {
            throw new SellException(500,e.getMessage());
        }

        return ResultVOUtil.success();


    }


}
