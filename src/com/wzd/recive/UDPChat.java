package com.wzd.recive;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author ：ZeDongW
 * @version : 1.0
 * @ClassName : UDPChat
 * @description：UDP聊天线程
 * @modified By：
 * @date ：Created in 2019/02/01/0001 7:47
 */
public class UDPChat implements Runnable{
    @Override
    public void run() {
        DatagramSocket sendSocket = null;
        DatagramSocket receiveSocket = null;
        System.out.println("服务端启动。。。。");
        try {
            //开启UDP发送服务
            sendSocket = new DatagramSocket();
            //开启UDP接收服务
            receiveSocket = new DatagramSocket(12001, InetAddress.getLocalHost());
            //接受用户输入的数据，将数据封装到数据包中
            Scanner scanner = new Scanner(System.in);
            String line = "";
            DatagramPacket datagramPacket1 = null;
            DatagramPacket datagramPacket2 = null;
            byte[] bytes = new byte[1024 * 8];
            while (true){
                datagramPacket2 = new DatagramPacket(bytes, bytes.length);
                receiveSocket.receive(datagramPacket2);
                System.out.println("发送端发送消息为： " + new String(bytes,0,datagramPacket2.getLength(),"Utf-8"));
                line = scanner.nextLine();
                datagramPacket1 = new DatagramPacket(line.getBytes(), line.getBytes().length, InetAddress.getLocalHost(), 12002);
                sendSocket.send(datagramPacket1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (receiveSocket != null){
                receiveSocket.close();
            }
            if (sendSocket != null){
                sendSocket.close();
            }
        }
    }
}
