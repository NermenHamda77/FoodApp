package com.example.finalproject.BottomNavigationBar.MealsOfCategory.view;

import com.example.finalproject.model.Meal;

import java.util.List;

public interface MealsOfCategoryView {
    public void getMealsByCategoryName(List<Meal> meals);
    public void CategoryMealsMsg(String error);
}
