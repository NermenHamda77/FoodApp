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

import com.example.finalproject.R;
import com.example.finalproject.model.Ingredient;

import java.util.List;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.ViewHolder>{

    private static final String TAG = "RecyclerviewAdapter";
    List<Ingredient> ingredients;
    Context context;
    OnClickListener listener;

    public IngredientAdapter(List<Ingredient> ingredients, Context context, OnClickListener listener) {
        this.ingredients = ingredients;
        this.context = context;
        this.listener = listener;
    }
    public void setCategory(List<Ingredient> updatedIngredients) {
        this.ingredients = updatedIngredients;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.search_card, parent, false);
        IngredientAdapter.ViewHolder viewHolder = new IngredientAdapter.ViewHolder(view);
        Log.i(TAG, "onCreateViewHolder: ");
        return viewHolder;    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
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
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private static final String TAG = "RecyclerviewAdapter";
    List<Category> categories;
    Context context;
    OnClickListener listener;


    public CategoryAdapter(List<Category> category, Context context, OnClickListener listener) {
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
/*
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