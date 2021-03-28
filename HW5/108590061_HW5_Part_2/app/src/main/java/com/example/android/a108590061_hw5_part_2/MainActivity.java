package com.example.android.a108590061_hw5_part_2;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private String Odr_txt;
    public static final String Msge = "com.example.android.a108590061_hw5_part_2.extra.MESSAGE";

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
                intn.putExtra(Msge,Odr_txt);
                startActivity(intn);

            }
        }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menu_item) {

        int menu_item_Id = menu_item.getItemId();

        if (menu_item_Id == R.id.action_settings) { return true; }
        return super.onOptionsItemSelected(menu_item);
    }

    public void displayTxt(String OrderMsg) {
        Toast.makeText(getApplicationContext(),
                OrderMsg,
                Toast.LENGTH_SHORT).show();
    }

    public void showDonutOrder(View view) {
        Odr_txt = getString((R.string.Order_Donut_show)) ;
        displayTxt(Odr_txt);
    }
    public void showIceCreamOrder(View view) {
        Odr_txt = getString((R.string.Order_IceCream_show)) ;
        displayTxt(Odr_txt);
    }
    public void showFroyoOrder(View view) {
        Odr_txt = getString((R.string.Order_Froyo_show)) ;
        displayTxt(Odr_txt);
    }

}
