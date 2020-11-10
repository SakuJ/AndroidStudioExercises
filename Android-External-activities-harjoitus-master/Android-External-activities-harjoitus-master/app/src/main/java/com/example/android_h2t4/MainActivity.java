package com.example.android_h2t4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.openMapButton).setOnClickListener(this);
        findViewById(R.id.goButton).setOnClickListener(this);
        findViewById(R.id.createCallButton).setOnClickListener(this);
    }

    private String getTextFieldtext()
    {
        EditText editori = findViewById(R.id.editText);
        String osoite = editori.getText().toString();
        editori.setText(null);
        return osoite;
    }

    public void onClick(View v)
    {
        if(v.getId() == R.id.openMapButton)
        {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW);
            mapIntent.setData(Uri.parse("https://www.google.fi/maps/place/65%C2%B003'36.0%22N+25%C2%B027'55.8%22E/@65.0601444,25.4644523,17.25z/data=!4m6!3m5!1s0x0:0x0!7e2!8m2!3d65.0599982!4d25.4654997"));
            startActivity(mapIntent);
        }
        else if (v.getId() == R.id.createCallButton)
        {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:+358206110200"));
            startActivity(callIntent);
        }
        else if (v.getId() == R.id.goButton)
        {
            String osoite = getTextFieldtext();

            Intent webIntent = new Intent(Intent.ACTION_VIEW);
            webIntent.setData(Uri.parse(osoite));
            startActivity(webIntent);
        }
    }
}
