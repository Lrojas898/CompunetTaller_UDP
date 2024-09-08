package com.example.compunettaller_udp.model;

import java.net.UnknownHostException;

public class PeerA extends Peer {

    public PeerA(int port) throws UnknownHostException {
        super(port);
    }

    @Override
    public void sendMessage(String message, String destinationIp, int destinationPort) {
        this.connection.sendDatagram(message, destinationIp, destinationPort);
    }

    public String getReceivedMessage(){
        return ipAddress + " : "+this.connection.getReceivedMessage();
    }


}
