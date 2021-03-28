package com.example.android.a108590061_hw5_part_2;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.widget.TextView;
import android.os.Bundle;


public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intns = getIntent();
        String mssg = " " + intns.getStringExtra(MainActivity.Msge);

        TextView txtV = findViewById(R.id.Odr_texts);
        txtV.setText(mssg);

    }
}
