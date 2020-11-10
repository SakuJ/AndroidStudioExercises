package com.example.android_h2t3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.englishButton).setOnClickListener(this);
        findViewById(R.id.suomiButton).setOnClickListener(this);
        findViewById(R.id.sverigeButton).setOnClickListener(this);
        findViewById(R.id.surpriseButton).setOnClickListener(this);

    }

    private String getTextFieldText()
    {
        EditText editor = findViewById(R.id.editText);
        String teksti = editor.getText().toString();
        editor.setText(null);
        return teksti;
    }

    public void onClick(View v){
        if(v.getId() == R.id.englishButton)
        {
            String juu = "Hello " + getTextFieldText();
            TextView tekstikentta = findViewById(R.id.textWiev);
            tekstikentta.setText(juu);
        }
        else if(v.getId() == R.id.suomiButton)
        {
            String juu = "Hei " + getTextFieldText();
            TextView tekstikentta = findViewById(R.id.textWiev);
            tekstikentta.setText(juu);
        }
        else if(v.getId() == R.id.sverigeButton)
        {
            String juu = "Hejjsan " + getTextFieldText();
            TextView tekstikentta = findViewById(R.id.textWiev);
            tekstikentta.setText(juu);
        }
        else if(v.getId() == R.id.surpriseButton)
        {
            String juu = "Moikkuliwooww " + getTextFieldText();
            TextView tekstikentta = findViewById(R.id.textWiev);
            tekstikentta.setText(juu);
        }

    }



}
