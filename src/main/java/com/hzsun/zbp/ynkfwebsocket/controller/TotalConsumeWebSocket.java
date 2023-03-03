package com.hzsun.zbp.ynkfwebsocket.controller;

import com.hzsun.zbp.ynkfwebsocket.constant.WebSocketConstants;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/totalConsume/1")
@RestController
@Data
@Slf4j
public class TotalConsumeWebSocket {

    /**
     * 用来记录当前连接数的变量
     */
    private static volatile int onlineCount = 0;

    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象
     */
    public static CopyOnWriteArraySet<TotalConsumeWebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    /**
     * 与某个客户端的连接会话，需要通过它来与客户端进行数据收发
     */
    private Session session;

    /**
    * REMARK   name
    */
    private String name;


    @OnOpen
    public void onOpen(Session session)  {
        setName("1");
        setSession(session);
        //首次建立连接异步调用ws接口  服务不重启情况下,可保证页面刷新后有数据
        if (WebSocketConstants.totalConsumeWebSocketCache != null) {
            this.session.getAsyncRemote().sendText("sync");
        }
        webSocketSet.add(this);
        log.info(name+"加入连接");
        log.info("当前在线人数为:" + webSocketSet.size());
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        log.info("Close a websocket. ");
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {

        log.info("当前收到了消息：" + message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("Error while websocket. ", error);
    }

    /**
     * 推送ws方法  用于传入kafka消息
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