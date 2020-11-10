package com.example.tietoliikenne_lab4_tehtava2;

import android.util.Log;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

interface EchoClientInterface{
    void onMessage(String message);
}

public class EchoClient extends WebSocketClient {

    EchoClientInterface observer;

    public EchoClient(URI serverUri, EchoClientInterface observer) {
        super(serverUri);
        this.observer = observer;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        Log.d("TESTI", "on Open called");
    }

    @Override
    public void onMessage(String message) {
        Log.d("TESTI", "on message called");
        observer.onMessage(message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        Log.d("TESTI", "on Close called");
    }

    @Override
    public void onError(Exception ex) {
        Log.d("TESTI", "on error called");
    }
}
