package com.wzd.updreceive;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

/**
 * @author ：ZeDongW
 * @version : 1.0
 * @ClassName : UDPServeice
 * @description：UDP接收
 * @modified By：
 * @date ：Created in 2019/01/31/0031 8:12
 */
public class UDPServeice {
    public static void main(String[] args) throws IOException {
        //建立UDP服务
        DatagramSocket datagramSocket = new DatagramSocket(12001,InetAddress.getLocalHost());
        while (true) {
            //准备数据
            byte[] bytes = new byte[1024];
            //将数据封装到数据包中
            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);

            datagramSocket.receive(datagramPacket);

            System.out.println(new String(bytes,"UTF-8"));
        }
    }
}
