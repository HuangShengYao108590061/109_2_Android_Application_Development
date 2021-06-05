package com.example.android.a108590061_hw13_part_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {


    SharedPreferences shared_preferences;
    private static final String shared_preferences_file = "108590061_HW13_Part_1";
    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    private TextView mScoreText1;
    private TextView mScoreText2;

    private int score_one;
    private int score_two;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreText1 = findViewById(R.id.score_1);
        mScoreText2 = findViewById(R.id.score_2);

        shared_preferences = getSharedPreferences(shared_preferences_file,MODE_PRIVATE);
        score_one = shared_preferences.getInt(STATE_SCORE_1,0);
        score_two = shared_preferences.getInt(STATE_SCORE_2,0);
        mScoreText1.setText(String.valueOf(score_one));
        mScoreText2.setText(String.valueOf(score_two));

    }

    public void increaseScore(View view) {

        int id_view = view.getId();
        switch (id_view) {

            case R.id.increaseTeam1:

                score_one++;
                mScoreText1.setText(String.valueOf(score_one));
                break;

            case R.id.increaseTeam2:

                score_two++;
                mScoreText2.setText(String.valueOf(score_two));
                break;
        }
    }

    public void decreaseScore(View view) {

        int id_views = view.getId();
        switch (id_views) {

            case R.id.decreaseTeam1:
                score_one--;
                mScoreText1.setText(String.valueOf(score_one));
                break;

            case R.id.decreaseTeam2:
                score_two--;
                mScoreText2.setText(String.valueOf(score_two));
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = shared_preferences.edit();
        editor.putInt(STATE_SCORE_1, score_one);
        editor.putInt(STATE_SCORE_2, score_two);
        editor.apply();
    }

    public void onClickReset(View view) {
        SharedPreferences.Editor editor = shared_preferences.edit();
        editor.clear().apply();
        score_one = 0;
        mScoreText1.setText(String.valueOf(score_one));
        score_two = 0;
        mScoreText2.setText(String.valueOf(score_two));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        int mode_night = AppCompatDelegate.getDefaultNightMode();
        if(mode_night == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.night_mode) {

            int mode_night = AppCompatDelegate.getDefaultNightMode();

            if (mode_night == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        return true;
    }



}