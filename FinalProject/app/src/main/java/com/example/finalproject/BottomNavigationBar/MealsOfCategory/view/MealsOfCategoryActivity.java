package com.example.finalproject.BottomNavigationBar.MealsOfCategory.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.finalproject.BottomNavigationBar.MealsOfCategory.presenter.AllMealsOfCategoryPresenterImp;
import com.example.finalproject.BottomNavigationBar.MealsOfCountry.presenter.AllMealsOfCountryPresenterImp;
import com.example.finalproject.Network.RemoteDataSourceAPI;
import com.example.finalproject.R;
import com.example.finalproject.db.MealLocalDataSourceImp;
import com.example.finalproject.model.Meal;
import com.example.finalproject.model.MealPlan;
import com.example.finalproject.model.MealsRepositoryImp;

import java.util.ArrayList;
import java.util.List;

public class MealsOfCategoryActivity extends AppCompatActivity implements MealsOfCategoryView , OnMealCatClick{
 String categoryName;
    private static final String TAG = "MealsOfCountryFragment";
    RecyclerView recyclerView;
    MealsOfCategoryAdapter mealsOfCategoryAdapter;

    AllMealsOfCategoryPresenterImp presenterImp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_of_category);
        recyclerView = findViewById(R.id.rv_meals_of_loca);
        recyclerView.setLayoutManager(new GridLayoutManager(this , 2));
        mealsOfCategoryAdapter = new MealsOfCategoryAdapter(new ArrayList<>() , this ,this);
        recyclerView.setAdapter(mealsOfCategoryAdapter);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            categoryName = bundle.getString("CountryName");

        }
        Log.i(TAG, "onCreateView: view");
        presenterImp = new AllMealsOfCategoryPresenterImp(this, MealsRepositoryImp.getInstance(RemoteDataSourceAPI.getInstance(), MealLocalDataSourceImp.getInstance(this)));
        presenterImp.getMealsByCategoryName(categoryName);


    }

    @Override
    public void getMealsByCategoryName(List<Meal> meals) {
        mealsOfCategoryAdapter.setList(meals);
        mealsOfCategoryAdapter.notifyDataSetChanged();
    }

    @Override
    public void CategoryMealsMsg(String error) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show();

    }


    @Override
    public void addToPlan(MealPlan plan) {
        presenterImp.addToPlan(plan);

    }
}