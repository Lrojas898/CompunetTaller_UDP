package com.example.compunettaller_udp.util;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPConnection extends Thread {

    private DatagramSocket socket;
    private int port;

    public UDPConnection(int port) {
        this.port = port;
        try {
            this.socket = new DatagramSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendDatagram(String message, String ipAddress, int destinationPort) {
        try {
            InetAddress address = InetAddress.getByName(ipAddress);
            byte[] buf = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, destinationPort);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String receive() {
        byte[] buf = new byte[256];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        try {
            socket.receive(packet);
            return new String(packet.getData(), 0, packet.getLength());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para cerrar el socket si es necesario
    public void close() {
        if (socket != null && !socket.isClosed()) {
            socket.close();
        }
    }
}
