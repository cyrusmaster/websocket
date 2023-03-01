//package com.hzsun.zbp.ynkfwebsocket.controller;
//
//
//import com.hzsun.zbp.ynkfwebsocket.kafka.KafkaConsumer;
//import com.hzsun.zbp.ynkfwebsocket.service.WebSocket;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//
//@org.springframework.stereotype.Controller
//public class Controller {
//
//	@Autowired
//	WebSocket webSocket;
//
//	@RequestMapping("{name}")
//	public ModelAndView demo(@PathVariable("name") String name, HttpServletRequest request, HttpServletResponse response){
//		//HttpSession session = request.getSession(false);
//		//System.out.println("seesion="+session);
//		//kafkaConsumer.kafkaListen(KafkaConsumer.record1);
//		//return  new ModelAndView("demo");
//		webSocket.setName("totalConsume");
//		//request.setAttribute("name",name);
//		return new ModelAndView("demo");
//
//	}
//
//
//
//}
