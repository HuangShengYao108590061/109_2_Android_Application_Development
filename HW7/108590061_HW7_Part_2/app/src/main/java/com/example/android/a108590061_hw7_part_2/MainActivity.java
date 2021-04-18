package com.example.android.a108590061_hw7_part_2;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.os.Bundle;


import java.util.LinkedList;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> recipe_titles_list = new LinkedList<>();
    private final LinkedList<String> info_dish = new LinkedList<>();

    private AdapterRecipe recipes_adapter;
    private RecyclerView dish_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String dish_recipe_titles[] = {getString(R.string.title_dish_recipe_one), getString(R.string.title_dish_recipe_two),
                                       getString(R.string.title_dish_recipe_three),getString(R.string.title_dish_recipe_four),
                                       getString(R.string.title_dish_recipe_five),getString(R.string.title_dish_recipe_six),
                                       getString(R.string.title_dish_recipe_seven)};

        String dish_recipe_info[] = {getString(R.string.recipe_info_one),getString(R.string.recipe_info_two),
                                       getString(R.string.recipe_info_three),getString(R.string.recipe_info_four),
                                       getString(R.string.recipe_info_five),getString(R.string.recipe_info_six),
                                       getString(R.string.recipe_info_seven)};

        for (int i = 0; i < 7; i++) {
            recipe_titles_list.addLast(dish_recipe_titles[i]);
            info_dish.addLast(dish_recipe_info[i]);
        }

        dish_view = findViewById(R.id.r_view_one);
        recipes_adapter = new AdapterRecipe(this, recipe_titles_list, info_dish);
        dish_view.setAdapter(recipes_adapter);
        dish_view.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void ToastShow(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
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
}