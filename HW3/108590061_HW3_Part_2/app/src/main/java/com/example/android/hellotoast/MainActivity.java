package com.example.android.hellotoast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;


    public static final String inx = "SayHello";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
    }

    public void SayHello(View view) {
        Intent in = new Intent(this,SecondActivity.class);
        in.putExtra(inx,mCount);
        startActivity(in);
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null){
            mShowCount.setText(Integer.toString(mCount));
        }

    }
}
