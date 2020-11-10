package com.example.tietoliikenne_lab4_tehtava2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, EchoClientInterface {

    EchoClient echoClient = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.sendBtn).setOnClickListener(this);

        openConnection();

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.sendBtn)
        {
            sendMessage();
        }
    }

    private void sendMessage() {
        if(echoClient != null && echoClient.isOpen())
        {
            EditText editori = findViewById(R.id.editText);
            String text = editori.getText().toString();
            echoClient.send(text);
            editori.getText().clear();
            hideKeyboard(MainActivity.this);
        }
    }

    private void openConnection() {
        try {
            echoClient = new EchoClient(new URI("wss://obscure-waters-98157.herokuapp.com"), this);
            echoClient.connect();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onMessage(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView textView = findViewById(R.id.textView);
                textView.append(message + "\n");
            }
        });

    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View v = activity.getCurrentFocus();
        if (v == null) { v = new View(activity); }
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
