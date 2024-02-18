package com.example.finalproject.Network;

import com.example.finalproject.model.CategoryResponse;
import com.example.finalproject.model.CountryResponse;
import com.example.finalproject.model.Ingredient;
import com.example.finalproject.model.IngredientResponse;
import com.example.finalproject.model.MealResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSourceAPI implements RemoteDataSource {
    private static final String url = "https://www.themealdb.com/api/json/v1/1/";
    private static final String TAG = "RemoteDataSourceAPI";
    MealService mealService;
    private static RemoteDataSourceAPI client = null;

    private RemoteDataSourceAPI() {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        mealService = retrofit.create(MealService.class);
    }

    public static RemoteDataSourceAPI getInstance() {
        if (client == null) {
            client = new RemoteDataSourceAPI();
        }
        return client;
    }

    @Override
    public Observable networkRandomMeals() {
        Observable<MealResponse> responseObservable = mealService.getRandomMeals().subscribeOn(Schedulers.io());
        return responseObservable;
    }

    @Override
    public Observable networkCategories() {
        Observable<CategoryResponse> responseObservable = mealService.getCategories().subscribeOn(Schedulers.io());
        return responseObservable;
    }

    @Override
    public Observable networkCountries() {
        Observable<CountryResponse> responseObservable = mealService.getCountry().subscribeOn(Schedulers.io());
        return responseObservable;

    }

    @Override
    public Observable networkIngredients(String ingredients) {

        Observable<IngredientResponse> responseObservable = mealService.getIngredients(ingredients).subscribeOn(Schedulers.io());
        return responseObservable;
    }

    @Override
    public Observable<MealResponse> networkMealsOfCountry(String countryName) {
        Observable<MealResponse> responseObservable = mealService.getMealsByCountryName(countryName).subscribeOn(Schedulers.io());
        return responseObservable;
    }

    @Override
    public Observable<MealResponse> networkMealsOfCategory(String categoryName) {
        Observable<MealResponse> responseObservable = mealService.getMealsByCategory(categoryName).subscribeOn(Schedulers.io());
        return responseObservable;
    }

    @Override
    public Observable<MealResponse> networkGetSearchMeals() {
        Observable<MealResponse> responseObservable = mealService.getSearchMeals().subscribeOn(Schedulers.io());
        return responseObservable;
    }

    @Override
    public Observable<MealResponse> networkGetMealDetails() {
        Observable<MealResponse> responseObservable = mealService.getMeals().subscribeOn(Schedulers.io());
        return responseObservable;
    }
}
