package com.example.p02_apii_ps;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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
        al.add(new Secular("Labour Day", "1 May 2020", R.drawable.gf));

        a2 = new ArrayList<Secular>();
        a2.add(new Secular("Chinese New Year", "25-26 January", R.drawable.cny));

        if (info.contentEquals("Secular")) {
            aa = new SecuAdapter(this, R.layout.ph, al);
            lv.setAdapter(aa);
        } else {
            aa = new SecuAdapter(this, R.layout.ph, a2);
            lv.setAdapter(aa);
        }
    }
}