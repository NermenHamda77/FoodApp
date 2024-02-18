package com.example.finalproject.Network;

import com.example.finalproject.model.CategoryResponse;
import com.example.finalproject.model.CountryResponse;
import com.example.finalproject.model.MealResponse;

import io.reactivex.rxjava3.core.Observable;

public interface RemoteDataSource {
    public Observable networkRandomMeals();
    public Observable<CategoryResponse> networkCategories();
    public Observable<CountryResponse> networkCountries();
    public Observable networkIngredients(String ingredients);

    public Observable<MealResponse> networkMealsOfCountry(String countryName);
    public Observable<MealResponse> networkMealsOfCategory(String categoryName);
    public Observable<MealResponse> networkGetSearchMeals();
    public Observable<MealResponse> networkGetMealDetails();

}
