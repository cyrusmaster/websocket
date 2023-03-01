package com.hzsun.zbp.ynkfwebsocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

 /**
  * REMARK   必须配置
  * @className   WebSockConfiger
  * @date  2022/10/29 14:14
  * @author  cyf
  */
@Configuration
public class WebSockConfiger {

	@Bean
	public ServerEndpointExporter registerWebSocketHandlers() {
		return new ServerEndpointExporter();
	}
}
