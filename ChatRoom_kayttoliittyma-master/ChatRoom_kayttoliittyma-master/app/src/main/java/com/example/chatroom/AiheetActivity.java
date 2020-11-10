package com.example.chatroom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AiheetActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<MyClass> arrayList = new ArrayList<>();
    private ListView listView;
    private MyAdapter myAdapter;
    String subString;
    AlertDialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aiheet);

        findViewById(R.id.addBtn).setOnClickListener(this);
        findViewById(R.id.chooseBtn).setOnClickListener(this);
        Toolbar myToolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(myToolbar);

        TextView textView = findViewById(R.id.textView);

        Bundle extras = getIntent().getExtras();
        if(extras == null)
            subString = "Pääikkuna";
        else
            subString = extras.getString("newAihe");
        textView.setText(subString);

        listView = findViewById(R.id.myListView);
        myAdapter = new MyAdapter(this, R.layout.list_row, arrayList);
        listView.setAdapter(myAdapter);

        arrayList.removeAll(arrayList);
        arrayList.add(new MyClass("Viesti1", "Kayttaja1"));
        arrayList.add(new MyClass("Viesti2", "Kayttaja2"));
        arrayList.add(new MyClass("Viesti3", "Kayttaja3"));
        arrayList.add(new MyClass("Viesti4", "Kayttaja4"));
        arrayList.add(new MyClass("Viesti5", "Kayttaja5"));
        arrayList.add(new MyClass("Viesti6", "Kayttaja6"));
        arrayList.add(new MyClass("Viesti7", "Kayttaja7"));
    }
    private void setSupportActionBar(Toolbar myToolbar) {

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.addBtn){
            AlertDialog.Builder myBuilder = new AlertDialog.Builder(AiheetActivity.this);
            View myView = getLayoutInflater().inflate(R.layout.dialog_message, null);
            final EditText editor = myView.findViewById(R.id.dialogEditText);
            Button messageAddBtn = myView.findViewById(R.id.messageAddBtn);

            messageAddBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view){
                    if(!editor.getText().toString().isEmpty()){
                        Toast.makeText(AiheetActivity.this, "Message sent", Toast.LENGTH_SHORT).show();
                        myDialog.dismiss();
                    }
                    else{
                        Toast.makeText(AiheetActivity.this, "Please write text", Toast.LENGTH_SHORT).show();
                        myDialog.dismiss();
                    }
                }

            });
            myBuilder.setView(myView);
            myDialog = myBuilder.create();

            Window window = myDialog.getWindow();
            window.setGravity(Gravity.BOTTOM);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            myDialog.show();
        }
        else if(v.getId() == R.id.chooseBtn){
            Intent intent = new Intent(AiheetActivity.this, AihealueetActivity.class);
            intent.putExtra("Aihe", subString);
            startActivity(intent);
        }
    }
}