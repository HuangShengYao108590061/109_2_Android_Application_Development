package com.example.android.a108590061_hw8_part_2;

import android.content.Intent;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import android.transition.TransitionInflater;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Build;
import android.os.Bundle;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView title_of_sports = findViewById(R.id.Detail_Title);
        ImageView pic_of_sports = findViewById(R.id.Detail_Sport_Image);
        TextView detail_of_sports = findViewById(R.id.Detail_Subtitle);

        getWindow().setSharedElementEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.shared_element_transition));

        Intent the_intent = getIntent();
        String titleString = the_intent.getStringExtra("Title");
        int imageInt = the_intent.getIntExtra("Image_Resource", 0);
        String details = the_intent.getStringExtra("Details");

        title_of_sports.setText(titleString);

        Glide.with(this).load(imageInt).into(pic_of_sports);
        detail_of_sports.setText(details);
    }
}
