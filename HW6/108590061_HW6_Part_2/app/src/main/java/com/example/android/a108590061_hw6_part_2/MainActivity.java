package com.example.android.a108590061_hw6_part_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private String Odr_txt;

    public static final String Msge = "com.example.android.a108590061_hw6_part_2.extra.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        FloatingActionButton flo_aBtn = findViewById(R.id.fab);
        flo_aBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intn = new Intent(MainActivity.this, OrderActivity.class);
                intn.putExtra(Msge, Odr_txt);

                startActivity(intn);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_mains, menu);
        return true;

    }

    public void showDonutOrder(View view) {
        Odr_txt = getString(R.string.Order_Donut);
        displayToast(Odr_txt);
    }

    public void showIceCreamOrder(View view) {
        Odr_txt = getString(R.string.Order_IceCream);
        displayToast(Odr_txt);
    }


    public void showFroyoOrder(View view) {
        Odr_txt = getString(R.string.Order_Froyo);
        displayToast(Odr_txt);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem selected_items) {

        switch (selected_items.getItemId()) {

            case R.id.action_order:

                Intent itemSelected_intn = new Intent(MainActivity.this, OrderActivity.class);
                itemSelected_intn.putExtra(Msge, Odr_txt);
                startActivity(itemSelected_intn);

                return true;

            case R.id.action_contact:

                displayToast(getString(R.string.msg_contact));

                return true;

            case R.id.action_status:

                displayToast(getString(R.string.msg_stat));

                return true;

            case R.id.action_favorites:

                displayToast(getString(R.string.msg_fav));

                return true;

            default:
        }

        return super.onOptionsItemSelected(selected_items);
    }


}
