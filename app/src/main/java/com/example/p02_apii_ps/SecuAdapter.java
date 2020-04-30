package com.example.p02_apii_ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecuAdapter extends ArrayAdapter<Secular> {
    private ArrayList<Secular> Secu;
    private Context context;
    private TextView tvName, tvDate;
    private ImageView ivImage;

    public SecuAdapter(Context context, int resource, ArrayList<Secular> objects){
        super(context, resource,objects);
        // Store the food that is passed to this adapter
        Secu = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
// "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.ph, parent, false);
        Secular s = Secu.get(position);
        tvName = (TextView) rowView.findViewById(R.id.tvName);
        tvName.setText(s.getName());

        tvDate = (TextView) rowView.findViewById(R.id.tvDate);
        tvDate.setText(s.getDate());

        ivImage = (ImageView) rowView.findViewById(R.id.ivProg);
        ivImage.setImageResource(s.getImage());

        return rowView;
    }
}
