package com.example.chatroom;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AihealueetActivity extends AppCompatActivity implements View.OnClickListener{

    ArrayList<MyClass> arrayList = new ArrayList<>();
    private ListView listView;
    private MyAdapter myAdapter;
    String selected;
    String teksti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aihealueet);

        findViewById(R.id.backBtn).setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        TextView textView = findViewById(R.id.textView2);
        teksti = extras.getString("Aihe");
        textView.setText(teksti);
        Toolbar myToolbar = findViewById(R.id.myToolbar2);
        setSupportActionBar(myToolbar);

        listView = findViewById(R.id.myListView2);
        myAdapter = new MyAdapter(this, R.layout.list_row, arrayList);
        listView.setAdapter(myAdapter);

        arrayList.removeAll(arrayList);
        arrayList.add(new MyClass("Pääikkuna", ""));
        arrayList.add(new MyClass("Autot", ""));
        arrayList.add(new MyClass("Jääkiekko", ""));
        arrayList.add(new MyClass("Jalkapallo", ""));
        arrayList.add(new MyClass("Oulussa tapahtuu", ""));
        arrayList.add(new MyClass("Mitä kuuluu", ""));
        arrayList.add(new MyClass("Muita juttuja", ""));
        arrayList.add(new MyClass("Jotain", ""));
        arrayList.add(new MyClass("Kirjaudu ulos", ""));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected = ((TextView)view.findViewById(R.id.viestiView)).getText().toString();
                if(selected == "Kirjaudu ulos"){

                    Intent intent3 = new Intent(AihealueetActivity.this, MainActivity.class);
                    startActivity(intent3);
                }
                else{
                    TextView textView = findViewById(R.id.textView2);
                    textView.setText(selected);
                    Intent intent = new Intent(AihealueetActivity.this, AiheetActivity.class);
                    intent.putExtra("newAihe", selected);
                    startActivity(intent);
                }
            }
        });
    }
    private void setSupportActionBar(Toolbar myToolbar) {

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.backBtn){

            Intent intent = new Intent(AihealueetActivity.this, AiheetActivity.class);
            startActivity(intent);
        }
    }
}
