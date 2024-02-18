package com.example.finalproject.BottomNavigationBar.MealsOfCountry.presenter;

import com.example.finalproject.BottomNavigationBar.MealsOfCountry.view.MealsOfCountryView;
import com.example.finalproject.model.MealPlan;
import com.example.finalproject.model.MealResponse;
import com.example.finalproject.model.MealsRepository;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class AllMealsOfCountryPresenterImp implements AllMealsOfCountryPresenter{
    private MealsOfCountryView view;
    private MealsRepository mealsRepository;

    private static final String TAG = "AllMealsOfCountryPresenterImp";

    public AllMealsOfCountryPresenterImp(MealsOfCountryView view, MealsRepository mealsRepository) {
        this.view = view;
        this.mealsRepository = mealsRepository;
    }

    @Override
    public void getMealsByCountryName(String countryName) {
        Observable<MealResponse> observable = mealsRepository.getAllMealsByCountryName(countryName);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MealResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull MealResponse mealResponse) {
                         view.showMeals(mealResponse.getMeals());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.CountryMealsMsg("Error" + e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void addToPlan(MealPlan plan) {
        Completable completable = mealsRepository.insertPlan(plan);
        completable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {

                        }, error -> {
                            view.showMsg("Error adding Meal to plan");
                        }

                );
    }
}
