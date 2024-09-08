package com.example.compunettaller_udp.model;

import java.net.UnknownHostException;

public class PeerB extends Peer {

    public PeerB(int port) throws UnknownHostException {
        super(port);
    }

    @Override
    public void sendMessage(String message, String destinationIp, int destinationPort) {
        this.connection.sendDatagram(message, destinationIp, destinationPort);
    }

    public String getReceivedMessage(){
        return this.connection.getReceivedMessage();
    }
}