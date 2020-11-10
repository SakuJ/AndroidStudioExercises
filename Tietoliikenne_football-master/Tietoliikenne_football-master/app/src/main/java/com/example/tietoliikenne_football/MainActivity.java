package com.example.tietoliikenne_football;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView lv;
    private ArrayAdapter<String> aa;
    private RequestQueue requestQueue;
    private List<String> nameList;
    private HashMap<String, String> nameID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue = Volley.newRequestQueue(this);
        nameList = new ArrayList<>();
        nameID = new HashMap<String, String>();
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nameList);

        lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nimi = nameList.get(position);
                String maaId = nameID.get(nimi);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("VALUE", maaId);
                startActivity(intent);
            }
        });

        String url = "https://api.football-data.org/v2/areas";
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                List<MyArea> result = MyParser.parseArea(response);
                List<String> areas = new ArrayList<>();
                for (MyArea a : result) {
                    nameID.put(a.getName(), a.getId());
                    areas.add(a.getName());
                }
                nameList.clear();
                nameList.addAll(areas);
                aa.notifyDataSetChanged();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonRequest);

    }
}
