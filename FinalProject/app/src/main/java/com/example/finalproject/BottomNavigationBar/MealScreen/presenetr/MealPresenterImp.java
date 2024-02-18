/*

 */
/*
package com.example.finalproject.BottomNavigationBar.MealScreen.presenetr;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.util.Log;

import com.example.finalproject.BottomNavigationBar.MealScreen.view.MealScreenView;
import com.example.finalproject.model.Meal;
import com.example.finalproject.model.MealResponse;
import com.example.finalproject.model.MealsRepository;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MealPresenterImp implements MealPresenter{

    private  MealScreenView view;
    private MealsRepository mealsRepository;

    public MealPresenterImp(MealScreenView view, MealsRepository mealsRepository) {
        this.view = view;
        this.mealsRepository = mealsRepository;
    }

    @Override
    public void getMealDetails(String mealName) {
         Observable<MealResponse> observable = mealsRepository.getAllMeal();

        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MealResponse>() {
                               @Override
                               public void onSubscribe(@NonNull Disposable d) {

                               }

                               @Override
                               public void onNext(@NonNull MealResponse mealResponse) {
                                   view.showMealDetails(mealResponse.getMeals());

                               }

                               @Override
                               public void onError(@NonNull Throwable e) {
                                   view.MealMsg("Error" + e.getMessage());

                               }

                               @Override
                               public void onComplete() {

                               }
                           }

                );

    }

    @Override
    public void addToFav(Meal meals) {
        Completable completable = mealsRepository.insertMeal(meals);
        completable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {

                }, error -> {
                    view.MealMsg("Error adding product to favorites");
                });
    }

    @Override
    public void removeFromFav(Meal meals) {
        mealsRepository.deleteMeal(meals)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> view.removeMeal(meals),
                        error -> Log.i(TAG, "removeFromFav: Error")
                );
    }
}
*/
/*
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
 */
