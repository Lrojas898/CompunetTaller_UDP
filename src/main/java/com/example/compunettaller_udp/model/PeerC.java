package com.example.compunettaller_udp.model;

import java.net.UnknownHostException;

public class PeerC extends Peer {

    public PeerC(int port) throws UnknownHostException {
        super(port);
    }

    @Override
    public void sendMessage(String message, String destinationIp, int destinationPort) {
        this.connection.sendDatagram(message, destinationIp, destinationPort);
    }

    public static void main(String[] args) throws UnknownHostException {
        // Configuración para PeerC
        PeerC peerC = new PeerC(5003); // Configura el puerto de recepción para PeerC

        // Ejemplo de envío de mensajes a PeerA y PeerB
        peerC.sendMessage("Hola desde PeerC a PeerA", "192.168.0.12", 5001);
        peerC.sendMessage("Hola desde PeerC a PeerB", "192.168.0.14", 5002);

        // Continuará recibiendo mensajes hasta que se detenga manualmente
    }
}

