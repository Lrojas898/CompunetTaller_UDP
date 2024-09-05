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
        // Configuración para PeerB
        PeerB peerB = new PeerB(5002); // Configura el puerto de recepción para PeerB



        // Ejemplo de envío de mensajes a PeerA y PeerC, toca cambiar tanto el puerto como las direcciones IP
        peerB.sendMessage("Hola desde PeerB a PeerA", "192.168.0.12", 5001);
        peerB.sendMessage("Hola desde PeerB a PeerC", "192.168.0.16", 5003);

        // Continuará recibiendo mensajes hasta que se detenga manualmente
    }
}