package com.example.android_h3t2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.startButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.startButton)
        {
            EditText editor = findViewById(R.id.time);
            String stringAika = editor.getText().toString();
            int aika = 0;
            if(!"".equals(stringAika))
            {
                aika = Integer.parseInt(stringAika);
            }

            Intent detailsIntent = new Intent(this, Main2Activity.class);
            detailsIntent.putExtra("AIKA", stringAika);

            startActivity(detailsIntent);
        }
    }
}
