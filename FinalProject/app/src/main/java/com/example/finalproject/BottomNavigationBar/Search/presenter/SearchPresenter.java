package com.example.finalproject.BottomNavigationBar.Search.presenter;

import com.example.finalproject.model.Meal;

public interface SearchPresenter {
    public void getCategories();
    public void getCountries();

    public void getIngrediants(String categoryName);

}
