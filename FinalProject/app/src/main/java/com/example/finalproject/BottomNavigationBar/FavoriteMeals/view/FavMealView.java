package com.example.finalproject.BottomNavigationBar.FavoriteMeals.view;

import com.example.finalproject.model.Meal;

import java.util.List;

public interface FavMealView {
    public void removeMeal(Meal meals);

    public void allMeals(List<Meal> meals);
}
