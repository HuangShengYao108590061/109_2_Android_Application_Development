package com.example.android.a108590061_hw7_part_2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class AdapterRecipe extends RecyclerView.Adapter<AdapterRecipe.WordViewHolder> {

    private final LinkedList<String> recipe_titles_list;
    private final LinkedList<String> info_dish;
    private final LayoutInflater mInflater;
    static final String EXTRA_MESSAGE = ".a108590061_hw7_part_2.extra.MESSAGE";

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView dish_title_views;
        public final TextView dish_info_views;
        final AdapterRecipe mAdapter;


        public WordViewHolder(View itemView, AdapterRecipe adapter) {
            super(itemView);
            dish_title_views = itemView.findViewById(R.id.dish_titles);
            dish_info_views = itemView.findViewById(R.id.recipes_info);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            int mPosition = getLayoutPosition();

            Context context = view.getContext();
            Intent intent = new Intent(context, RecipeShowInfo.class);
            intent.putExtra(EXTRA_MESSAGE, mPosition);
            context.startActivity(intent);
        }
    }

    public AdapterRecipe(Context context, LinkedList<String> title, LinkedList<String> content) {
        mInflater = LayoutInflater.from(context);
        this.recipe_titles_list = title;
        this.info_dish = content;
    }

    @Override
    public AdapterRecipe.WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View mItemView = mInflater.inflate(R.layout.recipe_lists_view, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(AdapterRecipe.WordViewHolder holder, int position) {

        String mCurrent = recipe_titles_list.get(position);
        String mContent = info_dish.get(position);

        holder.dish_title_views.setText(mCurrent);
        holder.dish_info_views.setText(mContent);
    }

    @Override
    public int getItemCount() {
        return recipe_titles_list.size();
    }
}