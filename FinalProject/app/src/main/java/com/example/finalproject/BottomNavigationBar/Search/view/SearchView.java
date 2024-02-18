package com.example.finalproject.BottomNavigationBar.Search.view;

import com.example.finalproject.model.Category;
import com.example.finalproject.model.Country;
import com.example.finalproject.model.Ingredient;
import com.example.finalproject.model.Meal;

import java.util.List;

public interface SearchView {
    public void showCategories(List<Category> categories) ;
    public void showCountries(List<Country> meals);
    public void showIngredients(List<Ingredient> ingredients);

    public void showMsg(String error);
    }
