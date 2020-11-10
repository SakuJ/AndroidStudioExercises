package com.example.chatroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.luotunnus_btn).setOnClickListener(this);
        findViewById(R.id.kirjaudu_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.luotunnus_btn)
        {
            Intent luotunnus_intent = new Intent(this, LuoTunnus.class);
            startActivity(luotunnus_intent);
        }
        else if(v.getId() == R.id.kirjaudu_btn)
        {
            Intent kirjaudu_intent = new Intent(this, AiheetActivity.class);
            startActivity(kirjaudu_intent);
        }

    }
}
