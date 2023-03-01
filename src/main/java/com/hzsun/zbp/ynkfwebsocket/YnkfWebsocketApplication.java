package com.hzsun.zbp.ynkfwebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class YnkfWebsocketApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(YnkfWebsocketApplication.class, args);
		Environment env = run.getEnvironment();
		System.out.println("----- ws://localhost:"+env.getProperty("server.port")+env.getProperty("server.servlet.context-path")+"/ -----");

	}


}
