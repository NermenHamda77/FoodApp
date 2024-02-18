package com.example.finalproject.BottomNavigationBar.Home.RandomMeal.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.finalproject.BottomNavigationBar.MealScreen.view.MealScreenActivity;
import com.example.finalproject.R;
import com.example.finalproject.model.Meal;

import java.util.List;

public class RandomMealsAdapter extends RecyclerView.Adapter<RandomMealsAdapter.ViewHolder> {
    private List<Meal> randomMeals;
    private Context context;
    private OnMealClickListener listener;

    private static final String TAG = "RandomMealsAdapter";
    public static final String EXTRA_MEAL_DETAILS = "mealDetails";

    public RandomMealsAdapter(List<Meal> randomMeals, Context context , OnMealClickListener listener){
        this.randomMeals = randomMeals;
        this.context = context;
        this.listener = listener;
    }

    public void setMeal(List<Meal> meals) {
        this.randomMeals = meals;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recyclerview_random_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RandomMealsAdapter.ViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder: ");

        Meal current = randomMeals.get(position);
        Glide.with(context).load(current.getStrMealThumb()).into(holder.randomImage);
        holder.randomName.setText(current.getStrMeal());
        holder.addFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onMealClick(current);
            }
        });
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MealScreenActivity.class);
                intent.putExtra(EXTRA_MEAL_DETAILS, current);
                Log.i(TAG, "onClick: in random"+ intent.hasExtra(EXTRA_MEAL_DETAILS));
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return randomMeals.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView randomImage;

        TextView randomName;
        Button addFav;
        public LinearLayout linearLayout;
        public View layout;
        CardView cardView;

        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            randomImage = v.findViewById(R.id.iv_rand_meal);
            randomName = v.findViewById(R.id.tv_random_category);
            addFav = v.findViewById(R.id.btn_add_fav_rand);
            linearLayout = v.findViewById(R.id.ll_random_row);
            cardView = v.findViewById(R.id.random_card);

        }
    }
}
