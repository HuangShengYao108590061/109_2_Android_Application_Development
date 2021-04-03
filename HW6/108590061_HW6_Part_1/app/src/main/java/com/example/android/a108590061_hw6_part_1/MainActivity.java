package com.example.android.a108590061_hw6_part_1;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.CheckBox;
import android.widget.Toast;
import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private String blank_space = " " ;
    private String topping_msg = "Topping: " ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void choose_option_checkbox(CheckBox TheBox ,  String selected_toppings){
        if(TheBox.isChecked())
        {
            if(!topping_msg.contains(selected_toppings)){ topping_msg = topping_msg + selected_toppings; }
        }
        else
        {
            if(topping_msg.contains(selected_toppings)) { topping_msg = topping_msg.replace(selected_toppings, blank_space);}
        }
    }

    public void Toast_msg(View view)
    {
        choose_option_checkbox((CheckBox) findViewById(R.id.Choco_syrup),"Chocolate Syrup ");
        choose_option_checkbox((CheckBox) findViewById(R.id.Sprinkles),"Sprinkles ");
        choose_option_checkbox((CheckBox) findViewById(R.id.Crushed_nuts),"Crushed Nuts ");
        choose_option_checkbox((CheckBox) findViewById(R.id.Cherries),"Cherries ");
        choose_option_checkbox((CheckBox) findViewById(R.id.Orio_Cookie_Crumbles),"Orio Cookie Crumbles ");

        Toast.makeText(this, topping_msg, Toast.LENGTH_SHORT).show();
    }
}