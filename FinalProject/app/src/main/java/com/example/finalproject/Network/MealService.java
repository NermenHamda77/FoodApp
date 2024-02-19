package com.example.finalproject.Network;

import com.example.finalproject.model.CategoryResponse;
import com.example.finalproject.model.CountryResponse;
import com.example.finalproject.model.Ingredient;
import com.example.finalproject.model.IngredientResponse;
import com.example.finalproject.model.MealResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealService {

    @GET("meals")
    Observable<MealResponse> getMeals();

    //get random meal
    @GET ("random.php")
    Observable<MealResponse> getRandomMeals();


    // get list of category
    @GET("categories.php")
    Observable<CategoryResponse> getCategories();


    // get list of country
    @GET("list.php?a=list")
    Observable<CountryResponse> getCountry();

    // get list of meals of specific Category
    @GET("filter.php?c=SeaFood")
    Observable<MealResponse> getCategoryMeals(@Query("c") String categoryName);


    // meals of country
    @GET("filter.php?")
    Observable<MealResponse> getMealsByCountryName(@Query("a") String mealsCountry);
    @GET("filter.php?")
    Observable<MealResponse> getMealsByCategory(@Query("c") String mealsCategory);

    @GET("list.php")
    Observable<IngredientResponse> getIngredients(@Query("i") String ingredients);

    @GET("search.php?")
    Observable<MealResponse>  getSearchMeals();

}




