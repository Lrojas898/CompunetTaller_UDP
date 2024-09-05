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

    public static void main(String[] args) throws UnknownHostException {
        PeerA peerA = new PeerA(5001);
        peerA.sendMessage("Hola desde PeerA", "192.168.0.14", 5002);
        peerA.sendMessage("Hola desde PeerA", "192.168.0.16", 5003);
    }
}
