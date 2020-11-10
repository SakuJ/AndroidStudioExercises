package com.example.h4t1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Activity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup radioGroup;

    private int sekunnit;
    private String tila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);

        findViewById(R.id.addBtn).setOnClickListener(this);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);



        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioBtn1)
                {
                    tila = "Workout";
                }
                else if(checkedId == R.id.radioBtn2)
                {
                    tila = "Pause";
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.addBtn)
        {
            EditText editori = findViewById(R.id.editText);
            String stringAika = editori.getText().toString();
            if(!"".equals(stringAika))
            {
                sekunnit = Integer.parseInt(stringAika);
            }

            WorkoutPart part = new WorkoutPart(sekunnit, tila);

            Intent resultIntent = new Intent();
            resultIntent.putExtra("NEW_PART", part);
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        }

    }
}
