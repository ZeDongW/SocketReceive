package com.wzd.tcpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ：ZeDongW
 * @version : 1.0
 * @ClassName : TCPServer
 * @description：TCP服务端
 * @modified By：
 * @date ：Created in 2019/02/02/0002 7:27
 */
public class TCPServer {
    public static void main(String[] args) {
        //TCP服务端
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(12001);
            System.out.println("!!!!!!");
            Socket accept = serverSocket.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
            char[] chars = new char[1024 * 8];
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {

                System.out.println("客户端发送信息为:" + line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
