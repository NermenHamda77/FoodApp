package com.example.finalproject.BottomNavigationBar.Category.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.finalproject.BottomNavigationBar.MealsOfCategory.view.MealsOfCategoryActivity;
import com.example.finalproject.BottomNavigationBar.MealsOfCountry.view.MealsOfCountryActivity;
import com.example.finalproject.R;
import com.example.finalproject.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private static final String TAG = "RecyclerviewAdapter";
    List<Category> categories;
    Context context;


    public CategoryAdapter(List<Category> category, Context context) {
        this.categories = category;
        this.context = context;
    }

    public void setCategory(List<Category> updatedCategories) {
        this.categories = updatedCategories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recyclerview_category_card, parent, false);
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

                Intent intent = new Intent(context , MealsOfCategoryActivity.class);
                intent.putExtra("CountryName" , current.getStrCategory());
                context.startActivity(intent);
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


