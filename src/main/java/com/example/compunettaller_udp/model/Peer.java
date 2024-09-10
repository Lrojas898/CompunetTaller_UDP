package com.example.compunettaller_udp.model;
import com.example.compunettaller_udp.util.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public abstract class Peer {

    protected InetAddress ipAddress;
    protected int port;
    protected UDPConnection connection;

    public Peer(int port) throws UnknownHostException {
        this.port = port;
        try {
            this.ipAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException uHe) {
            uHe.printStackTrace();
        }

        this.connection = new UDPConnection(port);
        this.connection.start(); // Comienza a escuchar en la red
    }

    // Método abstracto que cada Peer debe implementar
    public abstract void sendMessage(String message, String destinationIp, int destinationPort);

    // Método para obtener la conexión UDP
    public UDPConnection getConnection() {
        return this.connection;
    }

    public String getLocalIpAddress() {
        return this.ipAddress.getHostAddress();
    }

    public int getPort() {
        return this.port;
    }
}
