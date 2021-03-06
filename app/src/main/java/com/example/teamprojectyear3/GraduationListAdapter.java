package com.example.teamprojectyear3;
//Code from https://www.youtube.com/watch?v=E6vE8fqQPTE
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class GraduationListAdapter extends ArrayAdapter<Graduation> {

    private Context mContext;
    int mResource;

    public GraduationListAdapter(Context context, int resource, ArrayList<Graduation> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String FPCHS = getItem(position).getFPCHS();
        String maleGrad = getItem(position).getMaleGrad();
        String femaleGrad = getItem(position).getFemaleGrad();

        Graduation graduation = new Graduation(FPCHS, maleGrad, femaleGrad);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView NewFPCHS = (TextView) convertView.findViewById(R.id.textview1);
        TextView NewMaleGrad = (TextView) convertView.findViewById(R.id.textview2);
        TextView NewFemaleGrad = (TextView) convertView.findViewById(R.id.textview3);

        NewFPCHS.setText(FPCHS);
        NewMaleGrad.setText("Male: " + maleGrad);
        NewFemaleGrad.setText("Female: " + femaleGrad);

        return convertView;


    }
}