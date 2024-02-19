package com.example.finalproject.model;


import com.example.finalproject.Network.RemoteDataSourceAPI;
import com.example.finalproject.db.MealLocalDataSourceImp;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public class MealsRepositoryImp implements MealsRepository {
    RemoteDataSourceAPI remoteSource;   //Retrofit
    MealLocalDataSourceImp localDataSource;   //local data
    private static MealsRepositoryImp repo = null;

    public static MealsRepositoryImp getInstance(RemoteDataSourceAPI remoteSource,
                                                 MealLocalDataSourceImp localDataSource){
        if(repo == null){
            repo = new MealsRepositoryImp(remoteSource,localDataSource);
        }
        return repo;
    }

    private MealsRepositoryImp(RemoteDataSourceAPI remoteSource,
                               MealLocalDataSourceImp localDataSource) {
        this.remoteSource = remoteSource;
        this.localDataSource = localDataSource;
    }
    public Flowable<List<Meal>> getStoredMeals(){return localDataSource.getAllStoredMeals();}  //from repository


    @Override
    public Observable<MealResponse> getRandomMeal() {
        return remoteSource.networkRandomMeals();
    }

    @Override
    public Observable<MealResponse> getAllMeal() {
        return remoteSource.networkGetMealDetails();
    }

    @Override
    public Observable<CategoryResponse> getAllCategoriess() {
        return remoteSource.networkCategories();
    }

    @Override
    public Completable insertMeal(Meal meals) {
       return localDataSource.insertMeal(meals);

    }

    @Override
    public Completable deleteMeal(Meal meals) {
        return localDataSource.deleteMeal(meals);

    }

    @Override
    public Observable<CountryResponse> getAllCountries() {
        return remoteSource.networkCountries();
    }

    @Override
    public Observable<MealResponse> getAllMealsByCountryName(String countryName) {
        return remoteSource.networkMealsOfCountry(countryName);
    }

    @Override
    public Observable<MealResponse> getAllMealsByCategoryName(String categoryName) {
        return remoteSource.networkMealsOfCategory(categoryName);
    }

    @Override
    public Observable<MealResponse> getSearchMeals() {
        return remoteSource.networkGetSearchMeals();
    }

    /**
     * @return
     */
    @Override
    public Observable<IngredientResponse> getAllIngredients(String meal) {
        return remoteSource.networkIngredients(meal);
    }


    @Override
    public Flowable<List<MealPlan>> getStoredPlans() {
        return localDataSource.getAllStoredPlans();
    }

    @Override
    public Completable insertPlan(MealPlan plan) {
        return localDataSource.insertPlanInLocal(plan);
    }

    @Override
    public Completable deletePlan(MealPlan plan) {
        return localDataSource.deletePlan(plan);
    }

}
