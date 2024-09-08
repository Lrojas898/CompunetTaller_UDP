package com.example.compunettaller_udp.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import java.io.IOException;
import java.net.ServerSocket;
import com.example.compunettaller_udp.model.*;

public class Controller implements Initializable {

    PeerA peerA;
    @FXML
    protected Button sendBt;

    @FXML
    protected TextField IpTF;

    @FXML
    protected TextField portTF;

    @FXML
    protected TextArea message;

    @FXML
    protected TextArea chat;

    private String chatHistory = "";
    private String messegeNow = "";
    private String messegeDiferent = "";

    @FXML
    protected Label myIp;

    @FXML
    protected Label myPort;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        init();
        new Thread(() -> {
            while (true) {
                Platform.runLater(() -> {
                    messegeNow = peerA.getReceivedMessage();
                    if (!messegeNow.equals(messegeDiferent)) {
                        chatView();
                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void init() {
        String ipMy="";
        myIp.setText(ipMy);
        myPort.setText("");
        try {
            InetAddress ip = InetAddress.getLocalHost();
            ipMy = ip.getHostAddress();
            myIp.setText(ipMy);
            ServerSocket serverSocket = new ServerSocket(0);
            int port = serverSocket.getLocalPort();
            peerA = new PeerA(port);
            myPort.setText(String.valueOf(port));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void chatView(){
        chatHistory += "<--"+messegeNow + "\n";
        chat.setText(chatHistory);
        messegeDiferent = messegeNow;
    }

    public void sentChat(){
        if (!(IpTF.getText().isEmpty() || portTF.getText().isEmpty() || message.getText().isEmpty())){
            peerA.sendMessage(message.getText(),IpTF.getText(),Integer.parseInt(portTF.getText()));
            chatHistory += "--> Yo: " + message.getText() + "\n";
            chat.setText(chatHistory);
        }
    }



}


