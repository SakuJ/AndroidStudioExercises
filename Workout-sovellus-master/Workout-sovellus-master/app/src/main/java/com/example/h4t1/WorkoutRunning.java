package com.example.h4t1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WorkoutRunning extends AppCompatActivity implements Serializable, TextToSpeech.OnInitListener {

    public int index = 0;

    ArrayList <WorkoutPart> fullWorkout;

    TextToSpeech tts;
    TextToSpeech tts2;

    TextView tekstikentta3;
    TextView tekstikentta4;

    private Intent Intent3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_running);

        tts = new TextToSpeech(this, this);
        tts2 = new TextToSpeech(this, this);
        tekstikentta3 = findViewById(R.id.teksti);
        tekstikentta4 = findViewById(R.id.teksti2);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("fullWorkout");

        fullWorkout = (ArrayList<WorkoutPart>)bundle.getSerializable("bundle");

        TimerActivities();
    }
    public void TimerActivities()
    {
        tekstikentta3.setText(fullWorkout.get(index).name);

        tts2.speak(fullWorkout.get(index).name, TextToSpeech.QUEUE_FLUSH, null);
        CountDownTimer timer = new CountDownTimer(fullWorkout.get(index).seconds * 1000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                tekstikentta4.setText("" + millisUntilFinished / 1000);
                String aika = String.valueOf(millisUntilFinished / 1000);
                tts.speak(aika, TextToSpeech.QUEUE_FLUSH, null);
            }

            @Override
            public void onFinish() {
                index++;
                TimerActivities();
            }
        }.start();

        if(index >= fullWorkout.size())
        {
            timer.onFinish();
            Intent3 = new Intent(this, MainActivity.class);
            Intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(Intent3);
            finish();
        }
    }

    @Override
    public void onInit(int status) {

    }
}
