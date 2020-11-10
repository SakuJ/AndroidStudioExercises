package com.example.android_h2t1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<String> COUNTRIES = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.ADDButton).setOnClickListener(this);
        findViewById(R.id.REMOVEButton).setOnClickListener(this);

        COUNTRIES.add("Afghanistan");
        COUNTRIES.add("Algeria");
        COUNTRIES.add("Andorra");
        COUNTRIES.add("Fngola");
        COUNTRIES.add("France");

        ListView myListVieW = (ListView) findViewById(R.id.country_list_view);
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, COUNTRIES);
        myListVieW.setAdapter(aa);

    }

    private String getTextFieldText()
    {
        EditText editor = findViewById(R.id.EditText);
        String text = editor.getText().toString();
        editor.setText(null);
        return text;

    }

    private void poistaHenkilo(String maa)
    {
        for(int i = 0; i < COUNTRIES.size(); i++)
        {
            String nimiTaulukosta = COUNTRIES.get(i);
            if(nimiTaulukosta.equalsIgnoreCase(maa))
            {
                COUNTRIES.remove(i);
                break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ADDButton)
        {
            String maa = getTextFieldText();
            if (maa != null && maa.length() > 0)
            {
                COUNTRIES.add(maa);
            }
        }
        else if (v.getId() == R.id.REMOVEButton)
        {
            String maa = getTextFieldText();
            poistaHenkilo(maa);

        }



    }
}
