package com.example.tietoliikenne_lab1_tehtava3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String htmlText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.goButton).setOnClickListener(this);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

    }

    @Override
    public void onClick(View v) {
        AsyncTaskRunner runner = new AsyncTaskRunner();
        EditText editori = findViewById(R.id.editText);
        String urli = editori.getText().toString();
        runner.execute(urli);
    }

    private class AsyncTaskRunner extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream in = new BufferedInputStream(connection.getInputStream());
                htmlText = Utilities.fromStream(in);
            }
            catch (Exception e) {e.printStackTrace();}
            return htmlText;
        }
        protected void onPostExecute(String result) {
            // execution of result of Long time consuming operation
            htmlText = result;
            TextView textView = findViewById(R.id.tekstikentta);
            textView.setText(htmlText);
        }
    }



}
