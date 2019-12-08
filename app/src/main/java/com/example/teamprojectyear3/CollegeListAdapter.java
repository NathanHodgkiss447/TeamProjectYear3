package com.example.teamprojectyear3;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CollegeListAdapter extends ArrayAdapter<Colleges> {
    private Context mContext;
    int mResource;
    public CollegeListAdapter( Context context, int resource,  ArrayList<Colleges> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        String male = getItem(position).getMale();
        String female = getItem(position).getFemale();

        Colleges college = new Colleges(name, male, female);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView NewName = (TextView) convertView.findViewById(R.id.textview1);
        TextView NewMale = (TextView) convertView.findViewById(R.id.textview2);
        TextView NewFemale = (TextView) convertView.findViewById(R.id.textview3);

        NewName.setText(name);
        NewMale.setText("Male: "+ male);
        NewFemale.setText("Female: " + female);

        return convertView;
    }
}
