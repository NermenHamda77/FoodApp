package com.example.finalproject.BottomNavigationBar.Home.RandomMeal.presenter;

import com.example.finalproject.model.Meal;

public interface RandomMealsPreseneter {
    public void getRandomMeal();
    public void addToFav(Meal meals);
}
