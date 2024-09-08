package com.example.compunettaller_udp.model;
import com.example.compunettaller_udp.util.UDPConnection;
import java.io.IOException;
import java.net.*;
public abstract class Peer {

    protected InetAddress ipAddress;
    protected int port;
    protected UDPConnection connection;


    public Peer(int port) throws UnknownHostException {
        this.port = port;
        try{
            this.ipAddress= InetAddress.getLocalHost();
        }catch( UnknownHostException uHe){
            uHe.getStackTrace();
        }

        this.connection = UDPConnection.getInstance();
        this.connection.setPort(port);
        this.connection.start(); // Comienza a escuchar en la red
    }


    // Método abstracto que cada Peer debe implementar
    public abstract void sendMessage(String message, String destinationIp, int destinationPort);

}