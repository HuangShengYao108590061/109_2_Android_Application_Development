package com.example.android.helloconstraint;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import android.graphics.Color;
import android.view.View;

import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private Button Counts;
    private Button Resets;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        Counts = findViewById(R.id.button_count);
        Resets = findViewById(R.id.zerobutton);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void increasecount(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));

        Resets.setBackgroundColor(getResources().getColor(R.color.colorAccent));

        if ((mCount % 2) == 0){
            view.setBackgroundColor(Color.MAGENTA);
        }
        else{
            view.setBackgroundColor(Color.CYAN);
        }
    }
    public void Resettozero(View view){
        mCount = 0;
        mShowCount.setText(String.valueOf(mCount));
        view.setBackgroundColor(Color.GRAY);
        Counts.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }
}
