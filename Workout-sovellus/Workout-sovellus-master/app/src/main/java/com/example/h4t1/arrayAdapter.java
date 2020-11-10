package com.example.h4t1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class arrayAdapter extends ArrayAdapter<WorkoutPart> {

    private ArrayList<WorkoutPart> fullWorkout = new ArrayList<>();

    public arrayAdapter(Context context, int textViewResourceId, ArrayList<WorkoutPart> objects) {
        super(context, textViewResourceId, objects);
        fullWorkout = objects;

    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View listItem = convertView;

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listItem = inflater.inflate(R.layout.list_item, null);

        TextView name = (TextView) listItem.findViewById(R.id.textView_name);
        name.setText(fullWorkout.get(position).getName());

        TextView aika = (TextView) listItem.findViewById(R.id.textView_sekunnit);
        String aika_str = String.valueOf(fullWorkout.get(position).seconds);
        aika.setText(aika_str);

        return listItem;
    }
}
