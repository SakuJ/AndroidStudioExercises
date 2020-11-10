package com.example.h4t1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.AEADBadTagException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList <WorkoutPart> fullWorkout = new ArrayList<>();

    int ADD_NEW_PART_INTENT_ID = 8976;
    int aika;
    private ListView listView;
    private arrayAdapter aAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.newPartBtn).setOnClickListener(this);
        findViewById(R.id.startWorkoutBtn).setOnClickListener(this);

        listView = (ListView) findViewById(R.id.listView);
        aAdapter = new arrayAdapter(this, R.layout.list_item, fullWorkout);
        listView.setAdapter(aAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ADD_NEW_PART_INTENT_ID && resultCode == Activity.RESULT_OK)
        {
            String koko_aika;

            WorkoutPart newPart = (WorkoutPart) data.getSerializableExtra("NEW_PART");
            fullWorkout.add(newPart);
            aAdapter.notifyDataSetChanged();
            aika = aika + newPart.seconds;
            koko_aika = String.valueOf(aika);
            Toast toast = Toast.makeText(getApplicationContext(),"Aika yhteensä: " + koko_aika + " sekuntia", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.newPartBtn)
        {
            Intent intent = new Intent(this, Activity.class);
            startActivityForResult(intent, ADD_NEW_PART_INTENT_ID);
        }
        if(v.getId() == R.id.startWorkoutBtn)
        {

            Intent intent2 = new Intent(MainActivity.this, WorkoutRunning.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("bundle", fullWorkout);
            intent2.putExtra("fullWorkout", bundle);

            startActivity(intent2);
        }
    }
}
