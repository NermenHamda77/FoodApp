package com.example.finalproject.BottomNavigationBar.PlanMeals.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.finalproject.R;
import com.example.finalproject.model.MealPlan;

import java.util.List;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.ViewHolder> {
    private List<MealPlan> plans;
    private Context context;
    private PlanView listener;

    private static final String TAG = "PlanAdapter";

    public PlanAdapter(List<MealPlan> meals, Context context, PlanView listener) {
        this.plans = meals;
        this.context = context;
        this.listener = listener;
    }

    public void setList(List<MealPlan> updatePlans) {
        this.plans = updatePlans;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.plan_card, parent, false);
        PlanAdapter.ViewHolder viewHolder = new PlanAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MealPlan current = plans.get(position);
        Glide.with(context).load(current.getStrMealThumb()).into(holder.planMealImage);
        holder.planMealName.setText(current.getStrMeal());
        holder.removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.removePlan(current);
            }
        });
        holder.dayPlan.setText(current.getDayMeal());

        Log.i(TAG, "onBindViewHolder: ");
    }


    @Override
    public int getItemCount() {
        return plans.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView planMealImage;

        TextView planMealName;
        Button removeBtn;
        LinearLayout linearLayout;

        public View layout;
        TextView dayPlan;

        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            planMealImage = v.findViewById(R.id.iv_plan_meal);
            planMealName = v.findViewById(R.id.tv_plan_meal);
            removeBtn = v.findViewById(R.id.btn_remove_plan_meal);
            linearLayout = v.findViewById(R.id.ll_plan_row_details);
            dayPlan = v.findViewById(R.id.tv_plan_day);

        }
    }
}

/*
public class FavoriteAdapter  extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder>{

    private List<Meal> meals;
    private Context context;
    private FavMealView listener;

    private static final String TAG = "FavoriteAdapter";

    public FavoriteAdapter(List<Meal> meals, Context context, FavMealView listener) {
        this.meals = meals;
        this.context = context;
        this.listener = listener;
    }

    public void setList(List<Meal> updateMeals){
        this.meals = updateMeals;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recyclerview_fav_card, parent, false);
        FavoriteAdapter.ViewHolder viewHolder = new FavoriteAdapter.ViewHolder(view);
        return viewHolder;    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Meal current = meals.get(position);
        Glide.with(context).load(current.getStrMealThumb()).into(holder.favMealImage);
        holder.favMealName.setText(current.getStrCategory());
        holder.removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.removeMeal(current);
            }
        });

        Log.i(TAG, "onBindViewHolder: ");
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView favMealImage;

        TextView favMealName;
        Button removeBtn;
        LinearLayout linearLayout;
        public View layout;


        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            favMealImage = v.findViewById(R.id.iv_fav_meal);
            favMealName = v.findViewById(R.id.tv_fav_meal);
            removeBtn = v.findViewById(R.id.btn_remove_fav_meal);
            linearLayout = v.findViewById(R.id.ll_fav_row_details);

        }
    }
}

 */