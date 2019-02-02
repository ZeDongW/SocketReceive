package com.wzd.recive;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author ：ZeDongW
 * @version : 1.0
 * @ClassName : UDPRecive
 * @description：UDP接收
 * @modified By：
 * @date ：Created in 2019/01/31/0031 8:12
 */
public class UDPRecive {
    public static void main(String[] args) throws IOException {
    //建立UDP服务
    DatagramSocket datagramSocket = new DatagramSocket(12001,InetAddress.getLocalHost());
        //准备数据
        byte[] bytes = new byte[1024];
        //将数据封装到数据包中
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);

        datagramSocket.receive(datagramPacket);

        System.out.println(new String(bytes,0,datagramPacket.getLength(),"UTF-8"));
        //关闭连接
        datagramSocket.close();
    }
}
