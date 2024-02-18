package com.example.finalproject.BottomNavigationBar.FavoriteMeals.presenter;

import android.util.Log;

import com.example.finalproject.BottomNavigationBar.FavoriteMeals.view.FavMealView;
import com.example.finalproject.model.Meal;
import com.example.finalproject.model.MealsRepository;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FavoritePresenterImp implements FavoritePresenter{
    private FavMealView view;
    private MealsRepository repo;
    private static final String TAG = "FavoritePresenterImp";

    public FavoritePresenterImp(FavMealView view, MealsRepository repo) {
        this.view = view;
        this.repo = repo;
    }

    @Override
    public void removeFromFav(Meal meals) {
        repo.deleteMeal(meals)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> view.removeMeal(meals),
                        error -> Log.i(TAG, "removeFromFav: Error")
                );
    }

    @Override
    public void getStoredFav() {
        repo.getStoredMeals()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(meals -> {
                    view.allMeals(meals);
                });
    }

  


}
