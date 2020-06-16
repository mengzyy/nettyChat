package com.mzy.nettyChat.util;

import com.alibaba.fastjson.JSONObject;
import com.mzy.nettyChat.constant.ChatCode;

import java.util.HashMap;
import java.util.Map;


public class ChatProto {
    private int version = 1;
    /**
     * head
     */
    private int uri;
    /**
     * meg体
     */
    private String body;
    /**
     * extend
     */
    private Map<String, Object> extend = new HashMap<String,Object>();

    public ChatProto(int head, String body) {
        this.uri = head;
        this.body = body;
    }

    public static String buildPingProto() {
        return buildProto(ChatCode.PING_PROTO, null);
    }

    public static String buildPongProto() {
        return buildProto(ChatCode.PONG_PROTO, null);
    }

    public static String buildSystProto(int code, Object mess) {
        ChatProto chatProto = new ChatProto(ChatCode.SYST_PROTO, null);
        chatProto.extend.put("code", code);
        chatProto.extend.put("mess", mess);
        return JSONObject.toJSONString(chatProto);
    }

    public static String buildAuthProto(boolean isSuccess) {
        ChatProto chatProto = new ChatProto(ChatCode.AUTH_PROTO, null);
        chatProto.extend.put("isSuccess", isSuccess);
        return JSONObject.toJSONString(chatProto);
    }

    public static String buildErorProto(int code, String mess) {
        ChatProto chatProto = new ChatProto(ChatCode.EROR_PROTO, null);
        chatProto.extend.put("code", code);
        chatProto.extend.put("mess", mess);
        return JSONObject.toJSONString(chatProto);
    }

    public static String buildMessProto(int uid, String nick, String mess) {
        ChatProto chatProto = new ChatProto(ChatCode.MESS_PROTO, mess);
        chatProto.extend.put("uid", uid);
        chatProto.extend.put("nick", nick);
        chatProto.extend.put("time", DateTimeUtil.getCurrentTime());
        return JSONObject.toJSONString(chatProto);
    }

    public static String buildProto(int head, String body) {
        ChatProto chatProto = new ChatProto(head, body);
        return JSONObject.toJSONString(chatProto);
    }

    public int getUri() {
        return uri;
    }

    public void setUri(int uri) {
        this.uri = uri;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
