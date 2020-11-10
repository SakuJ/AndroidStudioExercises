package com.example.chatroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LuoTunnus extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luo_tunnus);
        findViewById(R.id.luotunnus_btn2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.luotunnus_btn2) {
            Intent kirjaudu_intent2 = new Intent(this, AiheetActivity.class);
            startActivity(kirjaudu_intent2);
        }
    }
}
