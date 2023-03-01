package com.hzsun.zbp.ynkfwebsocket.controller;

import com.hzsun.zbp.ynkfwebsocket.constant.WebSocketConstants;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/totalConsume/{name}")
@RestController
@Data

public class TotalConsumeWebSocket {

    /**
     * 用来记录当前连接数的变量
     */
    private static volatile int onlineCount = 0;

    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象
     */
    public static CopyOnWriteArraySet<TotalConsumeWebSocket> webSocketSet = new CopyOnWriteArraySet<TotalConsumeWebSocket>();

    /**
     * 与某个客户端的连接会话，需要通过它来与客户端进行数据收发
     */
    private Session session;

    /**
    * REMARK   name
    */
    private String name;

    private static final Logger LOGGER = LoggerFactory.getLogger(TotalConsumeWebSocket.class);

    @OnOpen
    public void onOpen(@PathParam("name") String s ,Session session)  {
        //this.socketName = s;
        this.session = session;
        this.session.getAsyncRemote().sendText(WebSocketConstants.totalConsumeWebSocketCache);
        setName(s);
        webSocketSet.add(this);

        LOGGER.info(s+"加入连接");
        LOGGER.info("当前在线人数为:" + webSocketSet.size());
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        LOGGER.info("Close a websocket. ");
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {

        LOGGER.info("当前收到了消息：" + message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        LOGGER.error("Error while websocket. ", error);
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws Exception {
        if (this.session.isOpen()) {
            this.session.getBasicRemote().sendText(message);
        }
    }


    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        TotalConsumeWebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        TotalConsumeWebSocket.onlineCount--;
    }

}