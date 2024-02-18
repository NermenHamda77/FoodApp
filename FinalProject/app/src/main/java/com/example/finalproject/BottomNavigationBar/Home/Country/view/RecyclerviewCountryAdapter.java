package com.example.finalproject.BottomNavigationBar.Home.Country.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.BottomNavigationBar.MealsOfCountry.view.MealsOfCountryActivity;
import com.example.finalproject.R;
import com.example.finalproject.model.Country;

import java.util.List;

public class RecyclerviewCountryAdapter extends RecyclerView.Adapter<RecyclerviewCountryAdapter.ViewHolder> {
    private List<Country> meals;
    private Context context;

    private static final String TAG = "RecyclerviewCountryAdap";

    public RecyclerviewCountryAdapter(List<Country> meals, Context context) {
        this.meals = meals;
        this.context = context;
    }

    public void setCountry(List<Country> meals) {
        this.meals = meals;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recyclerview_country_card, parent, false);
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

                Intent intent = new Intent(context , MealsOfCountryActivity.class);
                intent.putExtra("CountryName" , current.getStrArea());
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView countryTitle;

        public View layout;
        public CardView cardView;


        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            countryTitle = v.findViewById(R.id.tv_country__card_name);
            cardView = v.findViewById(R.id.card_country);

        }
    }

}


