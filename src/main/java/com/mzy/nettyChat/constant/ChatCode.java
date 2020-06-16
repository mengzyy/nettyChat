package com.mzy.nettyChat.constant;

public class ChatCode {

    public static final int PING_CODE = 10015;
    public static final int PONG_CODE = 10016;

    public static final int AUTH_CODE = 10000;
    public static final int MESS_CODE = 10086;

    public static int PING_PROTO = 1 << 8 | 220; //ping消息
    public static int PONG_PROTO = 2 << 8 | 220; //pong消息
    public static int SYST_PROTO = 3 << 8 | 220; //系统消息
    public static int EROR_PROTO = 4 << 8 | 220; //错误消息
    public static int AUTH_PROTO = 5 << 8 | 220; //认证消息
    public static int MESS_PROTO = 6 << 8 | 220; //普通消息

    /**
     * 系统消息类型
     */
    public static final int SYS_USER_COUNT = 20001; // 在线用户数
    public static final int SYS_AUTH_STATE = 20002; // 认证结果
    public static final int SYS_OTHER_INFO = 20003; // 系统消息

}
