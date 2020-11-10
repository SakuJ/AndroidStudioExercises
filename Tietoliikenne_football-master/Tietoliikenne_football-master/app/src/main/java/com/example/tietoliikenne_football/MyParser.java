package com.example.tietoliikenne_football;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MyParser {

    public static List<MyArea> parseArea(JSONObject object)
    {
        List<MyArea> lista = new ArrayList<>();
        try
        {
            JSONArray areas = object.getJSONArray("areas");
            for(int i = 0; i < areas.length(); i++)
            {
                String areaId = ((JSONObject)areas.get(i)).getString("id");
                String areaName = ((JSONObject)areas.get(i)).getString("name");
                lista.add(new MyArea(areaId,areaName));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    public static List<String> parseLeague(JSONObject object)
    {
        List<String> lista = new ArrayList<>();
        try
        {
            JSONArray competitions = object.getJSONArray("competitions");
            for(int i = 0; i < competitions.length(); i++)
            {
                String name = ((JSONObject)competitions.get(i)).getString("name");
                lista.add(name);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
