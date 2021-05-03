package com.example.android.a108590061_hw8_part_2;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.annotation.NonNull;
import android.view.View;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private static final String data_of_the_sports = "Sports_data";

    private AdapterOfSport the_sport_adapter;
    private ArrayList<Sport> the_sport_lists;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        the_sport_lists = new ArrayList<>();

        if (savedInstanceState != null) {
            the_sport_lists.clear();
            the_sport_lists = savedInstanceState.getParcelableArrayList(data_of_the_sports);
        }

        else{

            initializeData();

        }

        the_sport_adapter = new AdapterOfSport(this, the_sport_lists);
        mRecyclerView.setAdapter(the_sport_adapter);

        the_sport_adapter.notifyDataSetChanged();

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(the_sport_lists, from, to);
                the_sport_adapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                the_sport_lists.remove(viewHolder.getAdapterPosition());
                the_sport_adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        helper.attachToRecyclerView(mRecyclerView);
    }

    private void initializeData() {

        String[] list_of_sports = getResources().getStringArray(R.array.sports_titles);
        String[] detail_of_sports = getResources().getStringArray(R.array.sports_details);
        String[] info_of_sports = getResources().getStringArray(R.array.sports_info);

        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sports_images);

        the_sport_lists.clear();

        for (int i = 0; i < list_of_sports.length; i++) {
            the_sport_lists.add(new Sport(list_of_sports[i], info_of_sports[i], sportsImageResources.getResourceId(i, 0), detail_of_sports[i]));
        }
        sportsImageResources.recycle();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(data_of_the_sports, the_sport_lists);
    }

    public void resetSports(View view) {
        initializeData();
    }

}
