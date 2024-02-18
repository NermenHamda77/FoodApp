package com.example.finalproject.BottomNavigationBar.MealsOfCountry.presenter;

import com.example.finalproject.model.MealPlan;

public interface AllMealsOfCountryPresenter {
    public void getMealsByCountryName(String countryName);
    public void addToPlan(MealPlan plan);

}
