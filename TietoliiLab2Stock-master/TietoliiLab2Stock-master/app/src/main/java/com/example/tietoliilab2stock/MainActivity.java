package com.example.tietoliilab2stock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG = MainActivity.class.getSimpleName();
    private ListView lv;
    private String id;
    private String name;
    EditText idEdit, nameEdit;
    ArrayList<HashMap<String, String>> stockList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stockList = new ArrayList<>();
        lv = (ListView)findViewById(R.id.list);

        idEdit = (EditText)findViewById(R.id.idEdit);
        nameEdit = (EditText)findViewById(R.id.nameEdit);

        findViewById(R.id.addBtn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        id = idEdit.getText().toString();
        name = nameEdit.getText().toString();

        new GetContacts().execute(id);
    }

    private class GetContacts extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this,"Json Data is downloading",Toast.LENGTH_LONG).show();

        }
        @Override
        protected String doInBackground(String... strings) {
            String idStr = new String(strings[0]);
            HttpHandler sh = new HttpHandler();
            String url = "https://financialmodelingprep.com/api/v3/company/profile/" + id;
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if(jsonStr != null){
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    JSONObject datas = jsonObj.getJSONObject("profile");

                    String price = datas.getString("price");
                    String name = datas.getString("companyName");

                    HashMap<String, String> data = new HashMap<>();

                    data.put("price", price);
                    data.put("companyName", name);

                    stockList.add(data);

                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),"Json parsing error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
            else{
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
            return null;
        }
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            ListAdapter adapter = new SimpleAdapter(MainActivity.this, stockList,
                    R.layout.list_item, new String[]{ "companyName","price"}, new int[]{R.id.stockName, R.id.stockPrice});
            lv.setAdapter(adapter);
        }

    }
}
