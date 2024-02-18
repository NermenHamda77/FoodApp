package com.example.finalproject.BottomNavigationBar.MealsOfCountry.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.finalproject.BottomNavigationBar.MealsOfCountry.presenter.AllMealsOfCountryPresenterImp;
import com.example.finalproject.Network.RemoteDataSourceAPI;
import com.example.finalproject.R;
import com.example.finalproject.db.MealLocalDataSourceImp;
import com.example.finalproject.model.Meal;
import com.example.finalproject.model.MealPlan;
import com.example.finalproject.model.MealsRepositoryImp;

import java.util.ArrayList;
import java.util.List;

public class MealsOfCountryActivity extends AppCompatActivity implements MealsOfCountryView, OnMealCountClickListener {
    private static final String TAG = "MealsOfCountryFragment";
    RecyclerView recyclerView;
    MealsOfCountryAdapter mealsOfCountryAdapter;

    AllMealsOfCountryPresenterImp presenterImp;
    String countryName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_of_country);
        // Inflate the layout for this fragment
        recyclerView = findViewById(R.id.rv_meals_of_loco);
        recyclerView.setLayoutManager(new GridLayoutManager(this , 2));
        mealsOfCountryAdapter = new MealsOfCountryAdapter(new ArrayList<>() , this  , this);
        recyclerView.setAdapter(mealsOfCountryAdapter);
        Log.i(TAG, "onCreateView: view");



        // take country name as an argument
        // String value = getArguments().getString("COUNTRY_NAME");


        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            countryName = bundle.getString("CountryName");

        }



        presenterImp = new AllMealsOfCountryPresenterImp(
                this,
                MealsRepositoryImp.getInstance(RemoteDataSourceAPI.getInstance(), MealLocalDataSourceImp.getInstance(this)));
        presenterImp.getMealsByCountryName(countryName);
    }


    @Override
    public void showMeals(List<Meal> meals) {
        mealsOfCountryAdapter.setList(meals);
        mealsOfCountryAdapter.notifyDataSetChanged();
    }

    @Override
    public void CountryMealsMsg(String error) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showMsg(String error) {
        Toast.makeText(this,"Error" + error,Toast.LENGTH_SHORT).show();

    }




    @Override
    public void addMealToPlan(MealPlan plan) {
        presenterImp.addToPlan(plan);
    }
}