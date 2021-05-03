package com.example.android.a108590061_hw8_part_1;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;
import android.view.View;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    private int levels = 0;
    private ImageView view_images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view_images = findViewById(R.id.TheBattery);
        view_images.setImageLevel(levels);

    }

    public void Battery_level_add(){
        if(levels < 6){
            levels ++;
            view_images.setImageLevel(levels);
        }
    }

    public void Battery_level_subtract(){
        if(levels > 0){
            levels --;
            view_images.setImageLevel(levels);
        }
    }

    public void TheBatteryLevel(View level_battery){
        switch (level_battery.getId()){
            case R.id.max_btn:
                Battery_level_add();
                break;
            case R.id.min_btn:
                Battery_level_subtract();
                break;
            default:
                break;
        }
    }
}