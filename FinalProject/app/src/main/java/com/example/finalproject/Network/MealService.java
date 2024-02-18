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


    // get list of meals of specific Country
   /* @GET("filter.php?a=Canadian")
    Observable<MealResponse> getCountryMeals(@Query("a") String areaName);
*/
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
/*
@GET("search.php?")
    fun getMealByName(@Query("s") s:String):Call<RandomMealResponse>
 */






/*
 @GET("categories.php")
    fun getCategories(): Call<CategoryResponse>

    @GET("filter.php?")
    fun getMealsByCategory(@Query("i") category:String):Call<MealsResponse>

    @GET ("random.php")
    fun getRandomMeal():Call<RandomMealResponse>

    @GET("lookup.php?")
    fun getMealById(@Query("i") id:String):Call<RandomMealResponse>

    @GET("search.php?")
    fun getMealByName(@Query("s") s:String):Call<RandomMealResponse>
 */
 /*
    @GET("meals")
    Call<MealResponse> getAllMeals();
   @GET("search.php?s")
    */