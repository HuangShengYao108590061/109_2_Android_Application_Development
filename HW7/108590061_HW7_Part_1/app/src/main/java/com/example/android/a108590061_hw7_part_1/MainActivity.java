package com.example.android.a108590061_hw7_part_1;


import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "droidcafe@droid.com", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }

    public void ToastShow(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_about) {
            ToastShow(getString(R.string.about_txt));
            return true;
        }
        if (id == R.id.menu_settings) {
            ToastShow(getString(R.string.settings_txt));
            return true;
        }
        if (id == R.id.menu_faq) {
            ToastShow(getString(R.string.faq_txt));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void DessertPicturesClicked(View view){
        Intent desserts_picture;
        switch (view.getId()){

            case R.id.the_donut:
                desserts_picture = new Intent(this, ChildoneActivity.class);
                startActivity(desserts_picture);
                ToastShow(getString(R.string.droid_cafe_donut));
                break;

            case R.id.the_ice_cream_sandwich:
                desserts_picture = new Intent(this, ChildtwoActivity.class);
                startActivity(desserts_picture);
                ToastShow(getString(R.string.droid_cafe_ice_cream_sandwich));
                break;

            case R.id.the_frozen_yogurt:
                desserts_picture = new Intent(this, ChildthreeActivity.class);
                startActivity(desserts_picture);
                ToastShow(getString(R.string.droid_cafe_frozen_yogurt));
                break;

            default:
                break;
        }
    }
}
