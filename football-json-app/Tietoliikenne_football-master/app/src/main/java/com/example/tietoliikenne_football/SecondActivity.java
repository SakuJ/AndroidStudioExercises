package com.example.tietoliikenne_football;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    private List<String> leagues;
    private ListView leaguesListView;
    private ArrayAdapter<String> aa;
    private String divisionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        divisionId = intent.getStringExtra("VALUE");
        requestQueue = Volley.newRequestQueue(this);
        leagues = new ArrayList<>();
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, leagues);

        leaguesListView = (ListView) findViewById(R.id.list2);
        leaguesListView.setAdapter(aa);
        String url = "https://api.football-data.org/v2/competitions?areas=" + divisionId;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                List<String> resultsList = MyParser.parseLeague(response);
                leagues.clear();
                leagues.addAll(resultsList);
                if (leagues.size() == 0) leagues.add("No Leagues");
                aa.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
