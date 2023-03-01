package com.hzsun.zbp.ynkfwebsocket.constant;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
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
     * 防止来数据时跑remote (晨检头部信息)
     */
    public static boolean isComeMsg1 = false;

    /**
     * 防止来数据时跑remote (索证索票头部信息)
     */
    public static boolean isComeMsg2 = false;

    /**
     * 防止来数据时跑remote (留样头部信息)
     */
    public static boolean isComeMsg3 = false;

    /**
     * 防止来数据时跑remote (验收头部信息)
     */
    public static boolean isComeMsg5 = false;

    /**
     * 防止来数据时跑remote (预警)
     */
    public static boolean isComeMsg6 = false;

    /**
     * 防止来数据时跑remote (晨检全量数据)
     */
    public static boolean isComeMsg7 = false;

    /**
     * 防止来数据时跑remote (索针索票全量数据)
     */
    public static boolean isComeMsg8 = false;

    /**
     * 防止来数据时跑remote (留样全量数据)
     */
    public static boolean isComeMsg9 = false;

    /**
     * 防止来数据时跑remote (验收全量数据)
     */
    public static boolean isComeMsg10 = false;

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

    ///**
    // * 晨检列表增量数据
    // */
    //public static JSONObject chenJianCdcWebSocketCache = new JSONObject();
    //
    ///**
    // * 晨检列表全量数据
    // */
    //public static JSONArray chenJianAllWebSocketCache = new JSONArray();
    //
    ///**
    // * 晨检详情全量数据
    // */
    //public static JSONArray chenJianDetailWebSocketCache = new JSONArray();
    //
    ///**
    // * 索证索票头部信息数据
    // */
    //public static JSONObject suoZhenWebSocketCache = new JSONObject();
    //
    ///**
    // * 索证索票列表增量数据
    // */
    //public static JSONObject suoZhenCdcWebSocketCache = new JSONObject();
    //
    ///**
    // * 索证索票列表全量数据
    // */
    //public static JSONArray suoZhenAllWebSocketCache = new JSONArray();
    //
    ///**
    // * 留样头部信息数据
    // */
    //public static JSONObject sampleWebSocketCache = new JSONObject();
    //
    ///**
    // * 留样列表增量数据
    // */
    //public static JSONObject sampleCdcWebSocketCache = new JSONObject();
    //
    ///**
    // * 留样列表全量数据
    // */
    //public static JSONArray sampleAllWebSocketCache = new JSONArray();
    //
    ///**
    // * 验收头部信息
    // */
    //public static JSONObject yanShouWebSocketCache = new JSONObject();
    //
    ///**
    // * 验收列表增量数据
    // */
    //public static JSONObject yanShouCdcWebSocketCache = new JSONObject();
    //
    ///**
    // * 验收列表全量数据
    // */
    //public static JSONArray yanShouAllWebSocketCache = new JSONArray();
    //
    ///**
    // * 验收详情全量数据
    // */
    //public static JSONArray yanShouDetailWebSocketCache = new JSONArray();
    //
    //
    ///**
    // * 预警数据 过0点时置零
    // */
    //public static JSONArray xieTongWebSocketCache = new JSONArray();


    /**
     * 获取最新一条值 后缀
     */
    public static String getLastMsgPlus = " --partition 0 --max-messages 1";

    /**
     * 获取最大偏移量(晨检头部信息)
     */
    public static String getMaxOffsetCmd1 = "/opt/kafka/kafka_2.12-2.8.1/bin/./kafka-run-class.sh kafka.tools.GetOffsetShell --broker-list 10.45.207.181:19092 --topic realtime.app.mc_top";

    /**
     * 获取最新一条值 前缀(晨检头部信息)
     */
    public static String getLastMsgPre1 = "/opt/kafka/kafka_2.12-2.8.1/bin/./kafka-console-consumer.sh --bootstrap-server 10.45.207.181:19092 --topic realtime.app.mc_top --offset ";

    /**
     * 获取最大偏移量(晨检列表全量)
     */
    public static String getMaxOffsetCmd2 = "/opt/kafka/kafka_2.12-2.8.1/bin/./kafka-run-class.sh kafka.tools.GetOffsetShell --broker-list 10.45.207.181:19092 --topic realtime.app.mc_list_all";

    /**
     * 获取最新一条值 前缀(晨检列表全量)
     */
    public static String getLastMsgPre2 = "/opt/kafka/kafka_2.12-2.8.1/bin/./kafka-console-consumer.sh --bootstrap-server 10.45.207.181:19092 --topic realtime.app.mc_list_all --offset ";

    /**
     * 获取最大偏移量(索证索票头部信息)
     */
    public static String getMaxOffsetCmd3 = "/opt/kafka/kafka_2.12-2.8.1/bin/./kafka-run-class.sh kafka.tools.GetOffsetShell --broker-list 10.45.207.181:19092 --topic sz_top";

    /**
     * 获取最新一条值 前缀(索证索票头部信息)
     */
    public static String getLastMsgPre3 = "/opt/kafka/kafka_2.12-2.8.1/bin/./kafka-console-consumer.sh --bootstrap-server 10.45.207.181:19092 --topic sz_top --offset ";

    /**
     * 获取最大偏移量(索证索票列表全量)
     */
    public static String getMaxOffsetCmd4 = "/opt/kafka/kafka_2.12-2.8.1/bin/./kafka-run-class.sh kafka.tools.GetOffsetShell --broker-list 10.45.207.181:19092 --topic sz_list_all";

    /**
     * 获取最新一条值 前缀(索证索票列表全量)
     */
    public static String getLastMsgPre4 = "/opt/kafka/kafka_2.12-2.8.1/bin/./kafka-console-consumer.sh --bootstrap-server 10.45.207.181:19092 --topic sz_list_all --offset ";

    /**
     * 获取最大偏移量(留样头部信息)
     */
    public static String getMaxOffsetCmd5 = "/opt/kafka/kafka_2.12-2.8.1/bin/./kafka-run-class.sh kafka.tools.GetOffsetShell --broker-list 10.45.207.181:19092 --topic realtime.app.iot_top";

    /**
     * 获取最新一条值 前缀(留样头部信息)
     */
    public static String getLastMsgPre5 = "/opt/kafka/kafka_2.12-2.8.1/bin/./kafka-console-consumer.sh --bootstrap-server 10.45.207.181:19092 --topic realtime.app.iot_top --offset ";

    /**
     * 获取最大偏移量(留样列表全量)
     */
    public static String getMaxOffsetCmd6 = "/opt/kafka/kafka_2.12-2.8.1/bin/./kafka-run-class.sh kafka.tools.GetOffsetShell --broker-list 10.45.207.181:19092 --topic realtime.app.iot_list_all";

    /**
     * 获取最新一条值 前缀(留样列表全量)
     */
    public static String getLastMsgPre6 = "/opt/kafka/kafka_2.12-2.8.1/bin/./kafka-console-consumer.sh --bootstrap-server 10.45.207.181:19092 --topic realtime.app.iot_list_all --offset ";

    /**
     * 获取最大偏移量(验收头部信息)
     */
    public static String getMaxOffsetCmd9 = "/opt/kafka/kafka_2.12-2.8.1/bin/./kafka-run-class.sh kafka.tools.GetOffsetShell --broker-list 10.45.207.181:19092 --topic realtime_ads.ord.top";

    /**
     * 获取最新一条值 前缀(验收头部信息)
     */
    public static String getLastMsgPre9 = "/opt/kafka/kafka_2.12-2.8.1/bin/./kafka-console-consumer.sh --bootstrap-server 10.45.207.181:19092 --topic realtime_ads.ord.top --offset ";

    /**
     * 获取最大偏移量(验收列表全量)
     */
    public static String getMaxOffsetCmd10 = "/opt/kafka/kafka_2.12-2.8.1/bin/./kafka-run-class.sh kafka.tools.GetOffsetShell --broker-list 10.45.207.181:19092 --topic realtime_ads.ord.list_all";

    /**
     * 获取最新一条值 前缀(验收列表全量)
     */
    public static String getLastMsgPre10 = "/opt/kafka/kafka_2.12-2.8.1/bin/./kafka-console-consumer.sh --bootstrap-server 10.45.207.181:19092 --topic realtime_ads.ord.list_all --offset ";

    /**
     * 获取最大偏移量(主屏协同模块实时数据)
     */
    public static String getMaxOffsetCmd11 = "/opt/kafka/kafka_2.12-2.8.1/bin/./kafka-run-class.sh kafka.tools.GetOffsetShell --broker-list 10.45.207.181:19092 --topic warning_monitor";

    /**
     * 获取最新一条值 前缀(主屏协同模块实时数据)
     */
    public static String getLastMsgPre11 = "/opt/kafka/kafka_2.12-2.8.1/bin/./kafka-console-consumer.sh --bootstrap-server 10.45.207.181:19092 --topic warning_monitor --offset ";


    /**
     * kafka 地址
     */
    public static String url;
    /**
     * 主机地址
     */
    public static String host;
    /**
     * 用户名
     */
    public static String user;
    /**
     * 密码
     */
    public static String pwd;

    /**
     * 端口
     */
    public static Integer port;


    //@Value("${self.kafka}")
    //public void setUrl(String url1) {
    //    url = url1;
    //}
    //
    //@Value("${self.host}")
    //public void setHost(String host1) {
    //    host = host1;
    //}
    //
    //@Value("${self.user}")
    //public void setUser(String user1) {
    //    user = user1;
    //}
    //
    //@Value("${self.pwd}")
    //public void setPwd(String pwd1) {
    //    pwd = pwd1;
    //}
    //
    //@Value("${self.port}")
    //public void setPort(Integer port1) {
    //    port = port1;
    //}
}