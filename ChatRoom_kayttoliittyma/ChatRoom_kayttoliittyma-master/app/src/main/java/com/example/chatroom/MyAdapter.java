package com.example.chatroom;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class MyAdapter extends ArrayAdapter<MyClass> {

    ArrayList<MyClass> arrayList = new ArrayList<>();

    public MyAdapter(Context context, int textViewResourceId,  ArrayList<MyClass> objects) {
        super(context, textViewResourceId , objects);
        arrayList = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View listItem = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listItem = inflater.inflate(R.layout.list_row, null);

        TextView kayttaja = listItem.findViewById(R.id.kayttajaView);
        kayttaja.setText(arrayList.get(position).getKayttaja());

        TextView viesti = (TextView) listItem.findViewById(R.id.viestiView);
        viesti.setText(String.valueOf(arrayList.get(position).getMessage()));

        return listItem;
    }
}