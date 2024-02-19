package com.example.finalproject.BottomNavigationBar.Search.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.BottomNavigationBar.MealsOfCountry.view.MealsOfCountryActivity;
import com.example.finalproject.R;
import com.example.finalproject.model.Category;
import com.example.finalproject.model.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    private List<Country> meals;
    private Context context;
    private List<Country> filteredCountries;

    private static final String TAG = "CountryAdapter";

    public CountryAdapter(List<Country> meals, Context context) {
        this.meals = meals;
        this.context = context;
        this.filteredCountries = new ArrayList<>(meals); //put all elements of the list inside it
    }

    public void filter(String query) {
        filteredCountries.clear();
        if (query.isEmpty()) {
            filteredCountries.addAll(meals); // If the query is empty, show the full list
        } else {
            String lowerCaseQuery = query.toLowerCase();
            for (Country country : meals) {
                if (country.getStrArea().toLowerCase().contains(lowerCaseQuery)) {
                    filteredCountries.add(country);
                }
            }
        }
        notifyDataSetChanged();
    }

    public void setCountry(List<Country> meals) {
        this.meals = meals;
        notifyDataSetChanged();
    }

    public List<Country> getCountries() {
        return meals;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.search_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder: ");
        Country current = meals.get(position);
        holder.countryTitle.setText(current.getStrArea());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });


    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView countryTitle;
        ImageView resultImage;
        public View layout;
        public CardView cardView;


        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            countryTitle = v.findViewById(R.id.tv_search_result);
            cardView = v.findViewById(R.id.search_result_card);
            resultImage = v.findViewById(R.id.iv_search_result);

        }
    }

}


