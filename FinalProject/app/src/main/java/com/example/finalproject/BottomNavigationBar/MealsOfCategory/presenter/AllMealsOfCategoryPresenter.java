package com.example.finalproject.BottomNavigationBar.MealsOfCategory.presenter;

import com.example.finalproject.model.Meal;
import com.example.finalproject.model.MealPlan;

public interface AllMealsOfCategoryPresenter {
    public void getMealsByCategoryName(String categoryName);
    public void addToPlan(MealPlan plan);

}
