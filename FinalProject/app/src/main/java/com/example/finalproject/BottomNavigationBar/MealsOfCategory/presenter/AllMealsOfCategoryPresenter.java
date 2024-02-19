package com.example.finalproject.BottomNavigationBar.MealsOfCategory.presenter;

import com.example.finalproject.model.Meal;
import com.example.finalproject.model.MealPlan;

public interface AllMealsOfCategoryPresenter {
     void getMealsByCategoryName(String categoryName);
     void addToPlan(MealPlan plan);

}
