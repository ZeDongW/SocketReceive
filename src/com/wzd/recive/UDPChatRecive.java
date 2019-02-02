package com.wzd.recive;

/**
 * @author ：ZeDongW
 * @version : 1.0
 * @ClassName : UDPChatRecive
 * @description：UDP聊天服务端
 * @modified By：
 * @date ：Created in 2019/02/01/0001 7:53
 */
public class UDPChatRecive {
    public static void main(String[] args) {
        Thread thread = new Thread(new UDPChat());
        thread.start();
    }
}
