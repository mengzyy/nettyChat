package com.mzy.nettyChat;


import com.mzy.nettyChat.server.impl.mzyChatServer;
import com.mzy.nettyChat.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ChatRoomMain {
    private static final Logger logger = LoggerFactory.getLogger(ChatRoomMain.class);

    public static void main(String[] args) {
        final mzyChatServer server =new mzyChatServer(Constants.DEFAULT_PORT);
        server.init();
        server.start();
        // 注册进程钩子，在JVM进程关闭前释放资源
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                server.shutdown();
                logger.warn(">>>>>>>>>> jvm shutdown");
                System.exit(0);
            }
        });
    }
}
