package com.example.android.hellotoast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent in = getIntent();
        int mCount = in.getIntExtra(MainActivity.inx,0);
        TextView mCountTextView = findViewById(R.id.Cnt);
        mCountTextView.setText(String.valueOf(mCount));
    }
}