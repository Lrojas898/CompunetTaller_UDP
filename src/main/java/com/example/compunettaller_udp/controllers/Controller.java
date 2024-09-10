package com.example.compunettaller_udp.controllers;
import com.example.compunettaller_udp.model.*;
import com.example.compunettaller_udp.util.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    private Button sendBt;
    @FXML
    private TextArea chat;
    @FXML
    private TextField IpTF;
    @FXML
    private TextField portTF;
    @FXML
    private TextArea message;
    @FXML
    private Label myIp;
    @FXML
    private Label myPort;

    private PeerA peerA;
    // Si deseas usar PeerB o PeerC, puedes instanciarlos también

    public Controller() {
        Platform.runLater(() -> {
            try {
                // Inicializar PeerA con su puerto correspondiente
                peerA = new PeerA(5001);

                // Actualizar la etiqueta de la IP y puerto para PeerA
                myIp.setText(peerA.getLocalIpAddress());
                myPort.setText(String.valueOf(peerA.getPort()));

                // Iniciar un hilo para escuchar mensajes
                new Thread(() -> {
                    while (true) {
                        String receivedMessage = peerA.getConnection().receive();
                        Platform.runLater(() -> chat.appendText("Received: " + receivedMessage + "\n"));
                    }
                }).start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    public void sentChat() {
        String ip = IpTF.getText();
        int port = Integer.parseInt(portTF.getText());
        String msg = message.getText();

        // Enviar mensaje usando PeerA
        peerA.sendMessage(msg, ip, port);

        // Mostrar el mensaje enviado en la interfaz
        chat.appendText("Sent: " + msg + "\n");

        // Limpiar los campos de entrada
        message.clear();
    }
}
