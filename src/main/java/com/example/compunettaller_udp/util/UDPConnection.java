package com.example.compunettaller_udp.util;

import java.io.IOException;
import java.net.*;

public class UDPConnection extends Thread {

    private DatagramSocket socket;
    private static UDPConnection instance;
    private static DatagramPacket packet;
    private static String receivedMessage;
    private int port;


    private UDPConnection() {}


    public static synchronized UDPConnection getInstance() {
        if (instance == null) {
            instance = new UDPConnection();
            System.out.println("Instancia creada:"+instance);
            packet= null;
            receivedMessage= "";
        }
        return instance;
    }


    public void setPort(int port) {
        this.port = port;
        try {
            this.socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    // Método para enviar mensajes a uno de los tres peer
    public void sendDatagram(String message, String ipAddress, int destinationPort) {
        try {
            InetAddress address = InetAddress.getByName(ipAddress);
            byte[] buffer = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, destinationPort);
            socket.send(packet);
            System.out.println("Mensaje enviado a " + ipAddress + ":" + destinationPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método que ejecuta la lógica de recepción de mensajes
    @Override
    public void run() {
        byte[] buffer = new byte[1024];
        while (true) {
            packet = new DatagramPacket(buffer, buffer.length);
            try {
                System.out.println("Esperando mensaje...");
                this.socket.receive(packet);
                receivedMessage = new String(packet.getData(), 0, packet.getLength()).trim();
                System.out.println("Mensaje recibido de " + packet.getAddress().getHostAddress() + ": " + receivedMessage);
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
        socket.close();
    }
    // Método para obtener la IP local automáticamente
    public String getLocalIpAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "127.0.0.1"; // Valor predeterminado en caso de error
        }
    }

    // Cierra el socket al finalizar
    public void closeConnection() {
        if (socket != null && !socket.isClosed()) {
            socket.close();
        }
    }


    public static DatagramPacket getPacket() {
        return packet;
    }
    public static String getReceivedMessage() {
        return receivedMessage;
    }
}
