package com.example.finalproject.Network;

import com.example.finalproject.model.CategoryResponse;
import com.example.finalproject.model.CountryResponse;
import com.example.finalproject.model.MealResponse;

import io.reactivex.rxjava3.core.Observable;

public interface RemoteDataSource {
     Observable networkRandomMeals();
     Observable<CategoryResponse> networkCategories();
     Observable<CountryResponse> networkCountries();
     Observable networkIngredients(String ingredients);

     Observable<MealResponse> networkMealsOfCountry(String countryName);
     Observable<MealResponse> networkMealsOfCategory(String categoryName);
     Observable<MealResponse> networkGetSearchMeals();
     Observable<MealResponse> networkGetMealDetails();

}
