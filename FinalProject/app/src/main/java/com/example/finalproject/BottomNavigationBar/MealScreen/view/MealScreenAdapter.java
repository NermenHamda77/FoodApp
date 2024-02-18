/*
package com.example.finalproject.BottomNavigationBar.MealScreen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.example.finalproject.model.Meal;

import java.util.List;

public class MealScreenAdapter extends RecyclerView.Adapter<MealScreenAdapter.ViewHolder> {
    private static final String TAG = "MealScreenAdapter";
    private List<Meal> meals;
    private Context context;

    public MealScreenAdapter(List<Meal> meals, Context context) {
        this.meals = meals;
        this.context = context;
    }

    public void setList(List<Meal> updateMeals){
        this.meals = updateMeals;
        notifyDataSetChanged();
    }*/
/*
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.ingredients_card, parent, false);
        MealScreenAdapter.ViewHolder viewHolder = new MealScreenAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Meal current = meals.get(position);
        holder.ingredientName.setText(current.getStrIngredient1());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public View layout;
        TextView ingredientName;
        LinearLayout linearLayout;


        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            ingredientName = v.findViewById(R.id.tv_gred_name);
            linearLayout = v.findViewById(R.id.ll_of_loca_gred);
            cardView = v.findViewById(R.id.card_ingred_loca);

        }
    }
}


*/
/*
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private static final String TAG = "RecyclerviewAdapter";
    List<Category> categories;
    Context context;
    OnCategoryClickListener listener;


    public CategoryAdapter(List<Category> category, Context context, OnCategoryClickListener listener) {
        this.categories = category;
        this.context = context;
        this.listener = listener;
    }

    public void setCategory(List<Category> updatedCategories) {
        this.categories = updatedCategories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.card_meal_loca, parent, false);
        CategoryAdapter.ViewHolder viewHolder = new CategoryAdapter.ViewHolder(view);
        Log.i(TAG, "onCreateViewHolder: ");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        Category current = categories.get(position);
        Glide.with(context).load(current.getStrCategoryThumb()).into(holder.categoryImage);
        holder.categoryName.setText(current.getStrCategory());
        Log.i(TAG, "onBindViewHolder: ");
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // listener.onCategoryClick(current);
            }
        });


    }

    @Override
    public int getItemCount() {
        return categories.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public View layout;
        ImageView categoryImage;
        TextView categoryName;
        LinearLayout linearLayout;


        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            categoryImage = v.findViewById(R.id.iv_meal_category);
            categoryName = v.findViewById(R.id.tv_meal_category);
            linearLayout = v.findViewById(R.id.ll_category);
            cardView = v.findViewById(R.id.card_category);

        }
    }

}
 */
