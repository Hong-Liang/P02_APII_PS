package com.example.p02_apii_ps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView lv;
    TextView tv;
    ArrayAdapter aa;
    ArrayList<Secular> al, a2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act2);

        lv = (ListView)this.findViewById(R.id.lv1);
        tv = (TextView) findViewById(R.id.tvSelect);

        Intent i = getIntent();
        //Get the String array named info we passed in
        String info = i.getStringExtra("info");
        tv.setText(info);

        al = new ArrayList<Secular>();
        al.add(new Secular("New Year", "1 January 2020", R.drawable.newyear));
        al.add(new Secular("National Day", "9 August 2020", R.drawable.national_day));

        a2 = new ArrayList<Secular>();
        a2.add(new Secular("Chinese New Year", "25-26 January 2020", R.drawable.cny));
        a2.add(new Secular("Vesak Day", "10 April 2020", R.drawable.vesak));
        a2.add(new Secular("Hari Raya Puasa", "24 May 2020", R.drawable.puasa));
        a2.add(new Secular("Hari Raya Haji", "31 July 2020", R.drawable.haji));
        a2.add(new Secular("Depavali Day", "14 November 2020", R.drawable.deepavali));
        a2.add(new Secular("Christmas Day", "25 December 2020", R.drawable.christmas));


        if (info.contentEquals("Secular")) {
            aa = new SecuAdapter(this, R.layout.ph, al);
            lv.setAdapter(aa);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Secular selectedFood = al.get(position);
                    Toast.makeText(MainActivity2.this, selectedFood.getName()
                                    + selectedFood.getDate(),
                            Toast.LENGTH_LONG).show();
                }
            });
        } else {
            aa = new SecuAdapter(this, R.layout.ph, a2);
            lv.setAdapter(aa);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Secular selectedFood = a2.get(position);
                    Toast.makeText(MainActivity2.this, selectedFood.getName()
                                    + ": " + selectedFood.getDate(),
                            Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}