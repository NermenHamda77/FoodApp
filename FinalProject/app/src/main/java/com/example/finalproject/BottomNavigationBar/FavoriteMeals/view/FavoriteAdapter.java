package com.example.finalproject.BottomNavigationBar.FavoriteMeals.view;

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
import com.example.finalproject.model.Meal;

import java.util.List;

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
        holder.favMealName.setText(current.getStrMeal());
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
