package com.example.mob_kayttoliittyma_h6t1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void bear(View v)
    {
        mp = MediaPlayer.create(this, R.raw.bear);
        mp.start();
    }
    public void wolf(View v)
    {
        mp = MediaPlayer.create(this, R.raw.wolf);
        mp.start();
    }
    public void elephant(View v)
    {
        mp = MediaPlayer.create(this, R.raw.elephant);
        mp.start();
    }
    public void lamb(View v)
    {
        mp = MediaPlayer.create(this, R.raw.lamb);
        mp.start();
    }
}
