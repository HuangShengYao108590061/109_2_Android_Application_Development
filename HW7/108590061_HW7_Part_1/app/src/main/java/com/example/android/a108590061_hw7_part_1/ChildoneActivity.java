package com.example.android.a108590061_hw7_part_1;


import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import android.widget.RadioButton;
import android.widget.Toast;

import android.view.View;
import android.os.Bundle;

public class ChildoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childone);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.info_droid_cafe_donut));

    }

    public void ToastShow(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void DonutBeverageRadioButton(View view) {

        boolean the_rd_btn_check = ((RadioButton) view).isChecked();

        switch (view.getId()) {

            case R.id.rd_one:
                if (the_rd_btn_check)
                    ToastShow(getString(R.string.selects_c));
                break;

            case R.id.rd_two:
                if (the_rd_btn_check)
                    ToastShow(getString(R.string.selects_cinnamon_tea));
                break;

            default:
                break;
        }

    }
}
