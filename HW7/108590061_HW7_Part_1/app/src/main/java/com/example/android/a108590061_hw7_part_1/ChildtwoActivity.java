package com.example.android.a108590061_hw7_part_1;


import android.widget.Toast;
import android.widget.RadioButton;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.os.Bundle;


public class ChildtwoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childtwo);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.info_droid_cafe_ice_cream_sandwich));

    }

    public void ToastShow(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void IceCreamSandwichRadioButton(View view) {

        boolean the_rad_btn_check = ((RadioButton) view).isChecked();

        switch (view.getId()) {

            case R.id.rad_btn_one:
                if (the_rad_btn_check)
                    ToastShow(getString(R.string.select_n_s));
                break;

            case R.id.rad_btn_two:
                if (the_rad_btn_check)
                    ToastShow(getString(R.string.select_n_ls));
                break;

            case R.id.rad_btn_three:
                if (the_rad_btn_check)
                    ToastShow(getString(R.string.select_n_xls));
                break;

            default:
                break;
        }

    }
}
