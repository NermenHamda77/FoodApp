package com.example.finalproject.model;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public interface MealsRepository {
      Observable<MealResponse> getRandomMeal();
      Observable<MealResponse> getAllMeal();


     Observable<CategoryResponse> getAllCategoriess();
     Completable insertMeal(Meal meals);
     Flowable<List<Meal>> getStoredMeals();

     Completable deleteMeal(Meal meals);

      Observable<CountryResponse> getAllCountries();

     Observable getAllMealsByCountryName(String countryName);
     Observable getAllMealsByCategoryName(String categoryName);

     Observable<MealResponse> getSearchMeals();

     Observable<IngredientResponse> getAllIngredients(String meal);

    //plan

     Flowable<List<MealPlan>> getStoredPlans();
     Completable insertPlan(MealPlan plan);
     Completable deletePlan(MealPlan plan);




}
