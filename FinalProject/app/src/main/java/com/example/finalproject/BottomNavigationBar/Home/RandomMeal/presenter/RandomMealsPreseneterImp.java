package com.example.finalproject.BottomNavigationBar.Home.RandomMeal.presenter;

import com.example.finalproject.BottomNavigationBar.Home.RandomMeal.view.RandomMealView;
import com.example.finalproject.model.MealResponse;
import com.example.finalproject.model.Meal;
import com.example.finalproject.model.MealsRepository;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class RandomMealsPreseneterImp implements RandomMealsPreseneter {
    RandomMealView view;
    private MealsRepository repo;
    private static final String TAG = "RandomMealsPreseneterImp";

    public RandomMealsPreseneterImp(RandomMealView view, MealsRepository repo) {
        this.view = view;
        this.repo = repo;
    }

    @Override
    public void getRandomMeal() {
        Observable<MealResponse> observable = repo.getRandomMeal();

        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MealResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull MealResponse mealResponse) {
                        view.showMealData(mealResponse.getMeals());

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.showMealMsg("Error" + e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void addToFav(Meal meals) {
        Completable completable = repo.insertMeal(meals);
        completable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {

                }, error -> {
                    view.showMealMsg("Error adding product to favorites");
                });
    }
}
