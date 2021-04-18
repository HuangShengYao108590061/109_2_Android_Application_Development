package com.example.android.a108590061_hw7_part_1;


import android.widget.Toast;
import android.widget.RadioButton;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.os.Bundle;

public class ChildthreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childthree);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.info_droid_cafe_frozen_yogurt));

    }

    public void ToastShow(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void FrozenYogurtRadioButton(View view) {

        boolean the_rd_button_check = ((RadioButton) view).isChecked();

        switch (view.getId()) {

            case R.id.froyo_rd_btn_one:
                if (the_rd_button_check)
                    ToastShow(getString(R.string.select_n_y));
                break;

            case R.id.froyo_rd_btn_two:
                if (the_rd_button_check)
                    ToastShow(getString(R.string.select_u_s_y));
                break;

            default:
                break;
        }

    }
}
