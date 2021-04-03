package com.example.android.a108590061_hw6_part_2;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.DialogFragment;
//import android.app.DialogFragment;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.RadioButton;
import android.os.Bundle;


public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.Msge);

        TextView textView = findViewById(R.id.Your_Order);
        textView.setText(message);

    }

    public void CalendarPickDate(View view){
        DialogFragment d_frag = new CalendarFragment();
        d_frag.show(getSupportFragmentManager(), getString(R.string.pick_the_date));
    }

    public void ResCalendarPickDate(int year,int month,int dayOfMonth){
        String year_string = Integer.toString(year);
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(dayOfMonth);
        String date_message = "You selected the date: " +  month_string + "/" + day_string + "/" + year_string;
        Toast.makeText(getApplicationContext(),date_message,Toast.LENGTH_SHORT).show();
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {

        boolean chck_confirm = ((RadioButton) view).isChecked();

        switch (view.getId()) {

            case R.id.self_pick_up:
                if (chck_confirm)
                    displayToast(getString(R.string.selected_self_pick_up));
                break;

            case R.id.next_day_delivery:
                if (chck_confirm)
                    displayToast(getString(R.string.selected_next_day_delivery_by_ground));
                break;

            case R.id.same_day_delivery:
                if (chck_confirm)
                    displayToast(getString(R.string.selected_same_day_courier_messenger_service));
                break;

            default:
                break;
        }

    }

}

