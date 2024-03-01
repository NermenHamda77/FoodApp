package com.example.finalproject.BottomNavigationBar.Search.view;

import com.example.finalproject.model.Meal;

import java.util.List;

public interface AllMealsView {

    void showData(List<Meal> meals);

    void showMsg(String error);

}
