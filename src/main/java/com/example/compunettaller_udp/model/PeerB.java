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

    public static void main(String[] args) throws UnknownHostException {
        // Configura PeerB con un puerto
        PeerB peerB = new PeerB(5002);

        // Ejemplo de envío de mensajes
        peerB.sendMessage("Mensaje de PeerB a PeerA", "192.168.0.12", 5001);
        peerB.sendMessage("Mensaje de PeerB a PeerC", "192.168.0.16", 5003);
    }
}
