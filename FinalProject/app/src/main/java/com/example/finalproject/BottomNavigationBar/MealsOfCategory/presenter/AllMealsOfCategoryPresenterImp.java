package com.example.finalproject.BottomNavigationBar.MealsOfCategory.presenter;

import com.example.finalproject.BottomNavigationBar.MealsOfCategory.view.MealsOfCategoryView;
import com.example.finalproject.model.MealPlan;
import com.example.finalproject.model.MealResponse;
import com.example.finalproject.model.MealsRepository;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class AllMealsOfCategoryPresenterImp implements AllMealsOfCategoryPresenter {
    private MealsOfCategoryView view;
    private MealsRepository mealsRepository;
    private static final String TAG = "AllMealsOfCategoryPresenterImp";

    public AllMealsOfCategoryPresenterImp(MealsOfCategoryView view, MealsRepository mealsRepository) {
        this.view = view;
        this.mealsRepository = mealsRepository;
    }
    @Override
    public void getMealsByCategoryName(String categoryName) {

            Observable<MealResponse> observable = mealsRepository.getAllMealsByCategoryName(categoryName);
            observable.observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<MealResponse>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull MealResponse mealResponse) {
                            view.getMealsByCategoryName(mealResponse.getMeals());
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            view.CategoryMealsMsg("Error" + e.getMessage());

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
    }
    public void addToPlan(MealPlan plan) {
        Completable completable = mealsRepository.insertPlan(plan);
        completable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {

                        }, error -> {
                            view.CategoryMealsMsg("Error adding Meal to plan");
                        }

                );
    }
}
/*
 public void getMealsByCountryName(String countryName) {
        Observable<MealResponse> observable = mealsRepository.getByCountryName(countryName);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MealResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull MealResponse mealResponse) {
                         view.getMealsByCountryName(mealResponse.getMeals());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.CountryMealsMsg("Error" + e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
 */