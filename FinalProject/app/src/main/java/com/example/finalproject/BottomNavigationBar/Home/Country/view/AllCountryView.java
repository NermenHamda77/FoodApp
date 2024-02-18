package com.example.finalproject.BottomNavigationBar.Home.Country.view;

import com.example.finalproject.model.Country;
import com.example.finalproject.model.Meal;
import com.example.finalproject.model.MealResponse;

import java.util.List;

public interface AllCountryView {
    public void showCountryData(List<Country> meals);
    public void showCountryErrMsg(String error);
/*
    public void getCountryName(List<Meal> meals);
*/
}
