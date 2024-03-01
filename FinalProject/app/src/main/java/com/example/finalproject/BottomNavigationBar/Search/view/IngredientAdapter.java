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
import com.example.finalproject.model.Ingredient;

import java.util.List;

public class IngredientAdapter  extends RecyclerView.Adapter<IngredientAdapter.ViewHolder> {

    private static final String TAG = "RecyclerviewAdapter";
    List<Ingredient> ingredients;
    Context context;


    private List<Ingredient> filteredCategories;

    public IngredientAdapter(List<Ingredient> ingredients, Context context) {
        this.ingredients = ingredients;
        this.context = context;
       // this.filteredCategories = new ArrayList<>(category);
    }

/*    public void setIngredient(List<Ingredient> updatedCategories) {
        this.ingredients = updatedCategories;
        notifyDataSetChanged();
    }*/
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.search_card, parent, false);
        IngredientAdapter.ViewHolder viewHolder = new IngredientAdapter.ViewHolder(view);
        Log.i(TAG, "onCreateViewHolder: ");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Ingredient current = ingredients.get(position);
       // Glide.with(context).load(current.get()).into(holder.resultImage);
        holder.resultName.setText(current.getStrIngredient1());
        Log.i(TAG, "onBindViewHolder: ");
        holder.cardIngredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
       // ImageView resultImage;
        TextView resultName;
        public CardView cardIngredient;

        public View layout;

        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
           // resultImage = v.findViewById(R.id.iv_search_result);
            resultName = v.findViewById(R.id.tv_search_result);
            cardIngredient = v.findViewById(R.id.search_result_card);
        }
    }
}

/*
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private static final String TAG = "RecyclerviewAdapter";
    List<Category> categories;
    Context context;


    private List<Category> filteredCategories;

    public CategoryAdapter(List<Category> category, Context context) {
        this.categories = category;
        this.context = context;
        this.filteredCategories = new ArrayList<>(category);
    }

    public void filter(String query) {
        filteredCategories.clear();
        if (query.isEmpty()) {
            filteredCategories.addAll(categories);
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
 */