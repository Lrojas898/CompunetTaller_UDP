package com.example.compunettaller_udp.pruebas;

import java.net.DatagramSocket;

public class ChatClient {

    public static void main(String args[]) throws Exception {
        String host = "172.0.0.1";
        if (args.length < 1) {
            System.out.println("Usage: java ChatClient <server_hostname>");
            System.exit(0);
        } else {
            host = args[0];
        }
        DatagramSocket socket = new DatagramSocket();
        MessageReceiver r = new MessageReceiver(socket);
        MessageSender s = new MessageSender(socket, host);
        Thread rt = new Thread(r);
        Thread st = new Thread(s);
        rt.start(); st.start();
    }
}
