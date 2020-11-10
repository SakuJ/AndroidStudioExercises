package com.example.mob_kayttoliittyma_h8t1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    RadioGroup radioGroup;
    RadioButton radioButton;
    String maa;
    String country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(this);

        radioGroup = findViewById(R.id.radioGroup);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
         country = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button)
        {
            EditText editor = findViewById(R.id.editText);
            String nimi = editor.getText().toString();

            String jaatelo;

            CheckBox checkbox = findViewById(R.id.checkBox);
            if(checkbox.isChecked())
            {
                jaatelo = checkbox.getText().toString();
            }
            else
            {
                jaatelo = "";
            }
            String ika = checkButton();

            TextView tekstikentta = findViewById(R.id.tulostusKentta);

            tekstikentta.setText("My name is: " + nimi+ " " + jaatelo + " " + ika + " I live in: " + country);
        }
    }


    private String checkButton()
    {
        String ika;
        RadioButton rb1 = findViewById(R.id.radioButton1);
        RadioButton rb2 = findViewById(R.id.radioButton2);
        RadioButton rb3 = findViewById(R.id.radioButton3);
        if(rb1.isChecked())
        {
            ika = "0-20";
        }
        else if(rb2.isChecked())
        {
            ika = "21-49";
        }
        else if(rb3.isChecked())
        {
            ika = "50-";
        }
        else
        {
            ika = "";
        }
        return ika;
    }
}
