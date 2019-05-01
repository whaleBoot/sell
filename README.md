# sell
基于SpringBoot的企业微信点餐系统 - 本工程为后端


## 系统架构
```
前端：vue ----> webapp
后端：SpringBoot
后端管理系统：Bootstrap + FreeMarker + jQuery
交互：RESTful
部署架构：Nginx + Tomcat + Redis + Mysql
```
## SpringBoot技术栈
```
数据库：JPA + Mybatis
缓存：Redis(分布式Session、分布式锁)
消息推送：webSocket
```

## 微信特性
```
微信扫码登录
模板消息推送
微信支付和退款
```

## 项目设计

```
角色划分：买家、卖家
功能模块划分：商品订单类目等
...
```


# 知识点

```
DTO
VO
Entity
```

# 微信特性

### 手工获取openId

微信公众平台（服务号）—公众号设置—功能设置—网页授权域名，填写[natapp域名](http://whale.natapp1.cc/)

登录[内网穿透工具natapp](https://natapp.cn/)，下载客户端，

启动natapp natapp -authtoken=ac3ce84fe76123213

将认证文件下载，放到sell项目static目录下，确保访问[验证url](http://whale.natapp1.cc/MP_verify_1wdbJuFaF7jLABux.txt)，如果访问失败确认以下项目中是否配置了context-path，如果已经配置了context-path，可临时取消掉，待微信网页授权域名成功后方可修改回来。

#### 微信网页授权

访问[微信公众平台开发文档](https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1445241432)进入微信网页开发—微信网页授权

**第一步**：**用户同意授权，获取code**
[请求获取code](https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxbd8a87c079ee2b64&redirect_uri=http://whale.natapp1.cc/sell/weixin/auth&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect)
**第二步：** **通过code换取网页授权access_token**
[获取access_token](https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxbd8a87c079ee2b64&secret=SECRET&code=CODE&grant_type=authorization_code)

### 接入微信支付需要以下参数

```
appId
appSecret
商户号
商户密钥
商户证书
```




