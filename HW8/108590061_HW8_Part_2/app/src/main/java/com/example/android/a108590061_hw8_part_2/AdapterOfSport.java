package com.example.android.a108590061_hw8_part_2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Build;

import java.util.ArrayList;


class AdapterOfSport extends RecyclerView.Adapter<AdapterOfSport.ViewHolder> {

    private ArrayList<Sport> Sport_lists;
    private Context the_context;


    AdapterOfSport(Context context, ArrayList<Sport> sportsData) {
        this.Sport_lists = sportsData;
        this.the_context = context;
    }


    @NonNull
    @Override
    public AdapterOfSport.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(the_context).inflate(R.layout.activity_main_list_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterOfSport.ViewHolder holder, int position) {

        Sport currentSport = Sport_lists.get(position);
        holder.bindTo(currentSport);
    }

    @Override
    public int getItemCount() {
        return Sport_lists.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView pic_sport;
        private TextView the_titles;
        private TextView the_infos;


        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onClick(View view) {
            Sport currentSport = Sport_lists.get(getAdapterPosition());
            Intent the_intent_detail = new Intent(the_context, DetailActivity.class);
            the_intent_detail.putExtra("Title", currentSport.getTitle());
            the_intent_detail.putExtra("Image_Resource", currentSport.getImageResource());
            the_intent_detail.putExtra("Details", currentSport.getDetails());
            ActivityOptions Opt_Act = ActivityOptions.makeSceneTransitionAnimation((Activity) the_context, pic_sport, "transitionPics");
            the_context.startActivity(the_intent_detail, Opt_Act.toBundle());
        }

        void bindTo(Sport currentSport) {

            the_titles.setText(currentSport.getTitle());
            the_infos.setText(currentSport.getInfo());
            Glide.with(the_context).load(currentSport.getImageResource()).into(pic_sport);

        }

        ViewHolder(View itemView) {
            super(itemView);
            the_titles = itemView.findViewById(R.id.title);
            the_infos = itemView.findViewById(R.id.News_Subtitle);
            pic_sport = itemView.findViewById(R.id.the_sport_image);
            itemView.setOnClickListener(this);
        }


    }
}

