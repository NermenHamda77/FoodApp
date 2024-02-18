package com.example.finalproject.BottomNavigationBar.MealsOfCountry.view;

import com.example.finalproject.model.Meal;
import com.example.finalproject.model.MealPlan;

import java.util.List;

public interface MealsOfCountryView {
    public void showMeals(List<Meal> meals);
    public void CountryMealsMsg(String error);
    public void showMsg(String error);
}
