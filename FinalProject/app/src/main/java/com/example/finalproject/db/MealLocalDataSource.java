package com.example.finalproject.db;

import com.example.finalproject.model.Meal;
import com.example.finalproject.model.MealPlan;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

public interface MealLocalDataSource {
    Completable insertMeal(Meal meals);
    Completable deleteMeal(Meal meals);
    Flowable<List<Meal>> getAllStoredMeals();
    Completable deletePlan(MealPlan plans);
    Flowable<List<MealPlan>> getAllStoredPlans();
    Completable insertPlanInLocal(MealPlan plan);

}
