package com.example.android.a108590061_hw7_part_2;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;

import java.util.LinkedList;

public class RecipeShowInfo extends AppCompatActivity {
    LinkedList<String> dish_recipes_info_titles = new LinkedList<String>();
    LinkedList<String> recipes_desc_quotes = new LinkedList<String>();
    LinkedList<String> dish_cook_time = new LinkedList<>();
    LinkedList<String> ingredient_info = new LinkedList<>();
    LinkedList<String> info_how_to_cook_recipe = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_recipes);

        String info_titles_dish[]={getString(R.string.info_dish_recipe_titles_one),getString(R.string.info_dish_recipe_titles_two),
                                   getString(R.string.info_dish_recipe_titles_three),getString(R.string.info_dish_recipe_titles_four),
                                   getString(R.string.info_dish_recipe_titles_five),getString(R.string.info_dish_recipe_titles_six),
                                   getString(R.string.info_dish_recipe_titles_seven)};
        String quotes_dishes[]={getString(R.string.dish_one_quote),getString(R.string.dish_two_quote),getString(R.string.dish_three_quote),
                                getString(R.string.dish_four_quote),getString(R.string.dish_five_quote),getString(R.string.dish_six_quote),
                                getString(R.string.dish_seven_quote)};
        String recipe_cook_time[]={getString(R.string.cook_time_dish_one),getString(R.string.cook_time_dish_two),getString(R.string.cook_time_dish_three),
                                   getString(R.string.cook_time_dish_four),getString(R.string.cook_time_dish_five),getString(R.string.cook_time_dish_six),
                                   getString(R.string.cook_time_dish_seven)};
        String recipes_ingredients[]={getString(R.string.dish_one_cook_info),getString(R.string.dish_two_cook_info),getString(R.string.dish_three_cook_info),
                                      getString(R.string.dish_four_cook_info),getString(R.string.dish_five_cook_info),getString(R.string.dish_six_cook_info),
                                      getString(R.string.dish_seven_cook_info)};
        String how_to_cook_dish_recipes_info[]={getString(R.string.cook_dish_one),getString(R.string.cook_dish_two),getString(R.string.cook_dish_three),
                                                getString(R.string.cook_dish_four),getString(R.string.cook_dish_five),getString(R.string.cook_dish_six),
                                                getString(R.string.cook_dish_seven)};


        for(int i = 0; i < 7; i++)
        {
            dish_recipes_info_titles.addLast(info_titles_dish[i]);
            recipes_desc_quotes.addLast(quotes_dishes[i]);
            dish_cook_time.addLast(recipe_cook_time[i]);
            ingredient_info.addLast(recipes_ingredients[i]);
            info_how_to_cook_recipe.addLast(how_to_cook_dish_recipes_info[i]);
        }


        Intent intent = getIntent();
        int position = intent.getIntExtra(AdapterRecipe.EXTRA_MESSAGE, 0);
        TextView title_dish_cook_recipes = findViewById(R.id.dish_recipe_info_titles);
        TextView quotes_recipe_info = findViewById(R.id.recipe_infos);
        TextView cook_time_info = findViewById(R.id.cook_time_txt);
        TextView ingredient_cook = findViewById(R.id.ingredients_info);
        TextView info_of_how_to_cook = findViewById(R.id.how_to_cook_the_dish_info);

        String title_cook_dish_recipes_info = dish_recipes_info_titles.get(position);
        title_dish_cook_recipes.setText(title_cook_dish_recipes_info);
        String dishes_quotes_info = recipes_desc_quotes.get(position);
        quotes_recipe_info.setText(dishes_quotes_info);
        String cook_time_dish_recipe_info = dish_cook_time.get(position);
        cook_time_info.setText(cook_time_dish_recipe_info);
        String dish_ingredients_info = ingredient_info.get(position);
        ingredient_cook.setText(dish_ingredients_info);
        String dish_how_to_cook_info_recipes = info_how_to_cook_recipe.get(position);
        info_of_how_to_cook.setText(dish_how_to_cook_info_recipes);


        int images[] = {R.drawable.dish_recipe_one,R.drawable.dish_recipe_two,R.drawable.dish_recipe_three,R.drawable.dish_recipe_four,
                        R.drawable.dish_recipe_five,R.drawable.dish_recipe_six,R.drawable.dish_recipe_seven};

        ImageView image = findViewById(R.id.recipe_dish_picture);
        image.setImageResource(images[position]);
    }
}
