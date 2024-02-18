package com.example.finalproject.BottomNavigationBar.Home.RandomMeal.view;

import com.example.finalproject.model.Meal;

import java.util.List;

public interface RandomMealView {
    public void showMealData(List<Meal> meals);

    public void showMealMsg(String error);
    public void addMeal(Meal meals);     // add product to favorite


}

