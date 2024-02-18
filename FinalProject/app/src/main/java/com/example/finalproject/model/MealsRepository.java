package com.example.finalproject.model;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public interface MealsRepository {
    public  Observable<MealResponse> getRandomMeal();
    public  Observable<MealResponse> getAllMeal();


    public Observable<CategoryResponse> getAllCategoriess();
    public Completable insertMeal(Meal meals);
    public Flowable<List<Meal>> getStoredMeals();

    public Completable deleteMeal(Meal meals);

    public  Observable<CountryResponse> getAllCountries();

    public Observable getAllMealsByCountryName(String countryName);
    public Observable getAllMealsByCategoryName(String categoryName);

    public Observable<MealResponse> getSearchMeals();

    public Observable<IngredientResponse> getAllIngredients(String meal);

    //plan

    public Flowable<List<MealPlan>> getStoredPlans();
    public Completable insertPlan(MealPlan plan);
    public Completable deletePlan(MealPlan plan);


    Completable deleteMealsPlans();
    Flowable<List<MealPlan>>  receivedStoredPlans();


    Completable deleteAllFavMeals();


}
