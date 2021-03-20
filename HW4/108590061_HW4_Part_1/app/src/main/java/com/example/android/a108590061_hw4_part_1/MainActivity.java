package com.example.android.a108590061_hw4_part_1;

import androidx.appcompat.app.AppCompatActivity;


import android.view.View;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private int incrs_cnt;
    private TextView cnt_show;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cnt_show = findViewById(R.id.textView);
        if(savedInstanceState != null){

            String strx = savedInstanceState.getString("numCnt");
            cnt_show.setText(strx);
            incrs_cnt = Integer.parseInt(strx);

        }
    }

    public void onCounting(View view){

        incrs_cnt ++;
        cnt_show.setText(String.valueOf(incrs_cnt));

    }

    @Override
    protected void onSaveInstanceState(Bundle outState){

        super.onSaveInstanceState(outState);
        outState.putString("numCnt",cnt_show.getText().toString());
    }
}