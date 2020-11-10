package com.example.android_h3t2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        String aikaa = getIntent().getStringExtra("AIKA");
        int aika = 0;
        if(!"".equals(aikaa))
        {
            aika = Integer.parseInt(aikaa);
        }

        final TextView tekstikentta = findViewById(R.id.aikaKentta);

        CountDownTimer timer = new CountDownTimer(aika*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tekstikentta.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                tekstikentta.setText("Loppu");
                Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                r.play();
                finish();
            }
        }.start();

    }
}
