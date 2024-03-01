package com.example.finalproject.BottomNavigationBar.Search.view;

import com.example.finalproject.model.Category;
import com.example.finalproject.model.Country;
import com.example.finalproject.model.Ingredient;
import com.example.finalproject.model.Meal;

import java.util.List;

public interface SearchView {
     void showCategories(List<Category> categories) ;
     void showCountries(List<Country> meals);
    void showIngredients(List<Ingredient> meals);

     void showMsg(String error);
    }
