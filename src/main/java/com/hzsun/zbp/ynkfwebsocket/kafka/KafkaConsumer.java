package com.hzsun.zbp.ynkfwebsocket.kafka;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzsun.zbp.ynkfwebsocket.constant.WebSocketConstants;
import com.hzsun.zbp.ynkfwebsocket.controller.RechargeWebSocket;
import com.hzsun.zbp.ynkfwebsocket.controller.SingleConsumeWebSocket;
import com.hzsun.zbp.ynkfwebsocket.controller.TotalConsumeWebSocket;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;


/**
 * @author yuyue
 * @Classname: DemoController
 * @Description:
 * @Date: 2021-01-12 09:32
 */
@Component
@Service
@Slf4j
public class KafkaConsumer {



    /**
     * REMARK  今日消费
     * @methodName   kafkaListen
     * @return void
     * @date 2022/10/29 15:28
     * @author cyf
     */
    @KafkaListener(topics = "test2")
    public void kafkaTotalConsumeListen(ConsumerRecord record)  {

        log.info(LocalDateTime.now() + "消费数据 " + record.value().toString());
        WebSocketConstants.totalConsumeWebSocketCache = record.value().toString();

        for (TotalConsumeWebSocket socket : TotalConsumeWebSocket.webSocketSet) {
            try {
                //webSocket推送消息
                socket.sendMessage(record.value().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    ///**
    // * REMARK    今日单一消费
    // * @methodName   kafkaSingleConsumeListen
    // * @return void
    // * @date 2022/10/29 15:33
    // * @author cyf
    // */
    //@KafkaListener(topics = "realtime_ads.app.merchant_single_consume")
    //public void kafkaSingleConsumeListen(ConsumerRecord record) {
    //    String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
    //    //String now =
    //    System.err.println(now + ": 今日单一消费:" + record.value().toString());
    //    WebSocketConstants.singleConsumeWebSocketCache = record.value().toString();
    //    for (SingleConsumeWebSocket socket : SingleConsumeWebSocket.webSocketSet) {
    //        try {
    //            //webSocket推送消息
    //            socket.sendMessage(record.value().toString());
    //        } catch (Exception e) {
    //            e.printStackTrace();
    //        }
    //    }
    //}
    //
    //
    ///**
    // * REMARK    今日充值
    // * @methodName   kafkaTotalRechargeListen
    // * @return void
    // * @date 2022/10/29 15:33
    // * @author cyf
    // */
    //@KafkaListener(topics = "realtime_ads.app.screen_total_recharge")
    //public void kafkaTotalRechargeListen(ConsumerRecord record) {
    //    //record1 = record;
    //    //WebSocketConstants.isComeMsg1 = true;
    //    String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
    //    //String now =
    //    System.err.println(now + ": 今日充值:" + record.value().toString());
    //    WebSocketConstants.totalRechargeWebSocketCache = record.value().toString();
    //    for (RechargeWebSocket socket : RechargeWebSocket.webSocketSet) {
    //        try {
    //            //webSocket推送消息
    //            socket.sendMessage(record.value().toString());
    //        } catch (Exception e) {
    //            e.printStackTrace();
    //        }
    //    }
    //}









}
