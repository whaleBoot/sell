package com.whale.sell.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
  *@ClassName WebSocketConfig
  *@Description TODO
  *@Author coco
  *@Data 2019/5/5 11:31
  *@Version 1.0
  **/
@Component
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
