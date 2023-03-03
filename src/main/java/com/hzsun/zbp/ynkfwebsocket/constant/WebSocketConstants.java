package com.hzsun.zbp.ynkfwebsocket.constant;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author yuyue
 * @Classname: WebSocketConstants
 * @Description:
 * @Date: 2021-06-16 09:16
 */
@Order(1)
@Component
public class WebSocketConstants {

    /**
     * 缓存最新一次总体消费数据
     */
    public static String totalConsumeWebSocketCache ;

    /**
     * 缓存最新一次单一消费数据
     */
    public static String singleConsumeWebSocketCache ;


    /**
     * 缓存最新一次总体充值数据
     */
    public static String totalRechargeWebSocketCache ;


}