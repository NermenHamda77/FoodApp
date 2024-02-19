package com.example.finalproject.BottomNavigationBar.Search.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.finalproject.R;
import com.example.finalproject.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private static final String TAG = "RecyclerviewAdapter";
    List<Category> categories;
    Context context;


    private List<Category> filteredCategories;

    public CategoryAdapter(List<Category> category, Context context) {
        this.categories = category;
        this.context = context;
        this.filteredCategories = new ArrayList<>(category); // Initialize with the full list
    }

    public void filter(String query) {
        filteredCategories.clear();
        if (query.isEmpty()) {
            filteredCategories.addAll(categories); // If the query is empty, show the full list
        } else {
            String lowerCaseQuery = query.toLowerCase();
            for (Category category : categories) {
                if (category.getStrCategory().toLowerCase().contains(lowerCaseQuery)) {
                    filteredCategories.add(category);
                }
            }
        }
        notifyDataSetChanged();
    }




    public void setCategory(List<Category> updatedCategories) {
        this.categories = updatedCategories;
        notifyDataSetChanged();
    }
    public List<Category> getCategories() {
        return categories;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.search_card, parent, false);
        CategoryAdapter.ViewHolder viewHolder = new CategoryAdapter.ViewHolder(view);
        Log.i(TAG, "onCreateViewHolder: ");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category current = categories.get(position);
        Glide.with(context).load(current.getStrCategoryThumb()).into(holder.resultImage);
        holder.resultName.setText(current.getStrCategory());
        Log.i(TAG, "onBindViewHolder: ");
        holder.cardCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* Intent intent = new Intent(context , MealsOfCategoryActivity.class);
                intent.putExtra("CountryName" , current.getStrCategory());
                context.startActivity(intent);*/
            }
        });


    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView resultImage;
        TextView resultName;
        public CardView cardCategory;

        public View layout;

        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            resultImage = v.findViewById(R.id.iv_search_result);
            resultName = v.findViewById(R.id.tv_search_result);
            cardCategory = v.findViewById(R.id.search_result_card);
        }
    }
}

/*
package com.example.foodplanner;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.model.Meal;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{
    private static final String TAG = "SearchAdapter";
    Context context;
    List<Meal> meals;
    AllMealsView listener ;
    List<Meal> filteredMeals;
    List<Meal> mealList;
    OnFavouriteClickListener onFavMealClick;

    public SearchAdapter(Context context, List<Meal> meals, AllMealsView listener) {
        this.context = context;
        this.meals = meals;
        this.filteredMeals = new ArrayList<>(meals);
        this.listener = listener;
        mealList=new ArrayList<>();
    }

    public void setList(List<Meal> updateMeals){
        this.meals=updateMeals;
        mealList.addAll(updateMeals);
    }
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Meal> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mealList); // Add all meals if the search query is empty
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Meal meal : mealList) {
                    if (meal.getStrMeal().toLowerCase().contains(filterPattern)) {
                        filteredList.add(meal); // Add meal to filtered list if its name contains the search query
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            meals.clear(); // Clear current list of meals
            meals.addAll((List<Meal>) results.values); // Add filtered list to current list
            notifyDataSetChanged(); // Notify adapter of data change
        }
    };
    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder: ");
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_meal, parent, false);
        SearchAdapter.ViewHolder viewHolder = new SearchAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder: ");
        Meal current = meals.get(position);
        holder.mealName.setText(current.getStrMeal());

        Glide.with(context).load(meals.get(position).getStrMealThumb()).into(holder.mealPhoto);
        holder.addToFavIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle between two icons
                onFavMealClick.onFavMealClick(current);
                holder.addToFavIcon.setImageResource(R.drawable.redhearticon);
                holder.addToFavIcon.setTag("not_favorite");

                Toast.makeText(context, "Added To Favourite", Toast.LENGTH_SHORT).show();
            }
        });
        holder.cardMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MealDetailsActivity.class);
                intent.putExtra("mealDetailsObject", current);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "filteredMeals: ");
        return meals.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mealPhoto;
        TextView mealName;
        ImageView addToFavIcon;
        public CardView cardMeal;
        public View layout;

        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            mealPhoto = v.findViewById(R.id.iv_mealPhoto);
            mealName = v.findViewById(R.id.tv_mealName);
            cardMeal = v.findViewById(R.id.card_meal);
            addToFavIcon = v.findViewById(R.id.iv_addToFavourite);

        }
    }
}
 */