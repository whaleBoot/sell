package com.whale.sell.common.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ClassName WechatMpConfig
 * @Description  WXJava sdk 配置
 * @Author like
 * @Data 2019/3/12 14:14
 * @Version 1.0
 **/
@Component
public class WechatTestMpConfig {

    @Autowired
    private WechatAccountConfig wechatAccountConfig;

    @Bean
    public WxMpService wxTestMpService() {
        WxMpService wxTestMpService = new WxMpServiceImpl();
        wxTestMpService.setWxMpConfigStorage(wxTestMpConfigStorage());
        return wxTestMpService;
    }

    @Bean
    public WxMpConfigStorage wxTestMpConfigStorage() {
        WxMpInMemoryConfigStorage wxMpConfigStorage = new WxMpInMemoryConfigStorage();
        wxMpConfigStorage.setAppId(wechatAccountConfig.getTestMpAppId());
        wxMpConfigStorage.setSecret(wechatAccountConfig.getTestMpAppSecret());
        return wxMpConfigStorage;
    }
}
