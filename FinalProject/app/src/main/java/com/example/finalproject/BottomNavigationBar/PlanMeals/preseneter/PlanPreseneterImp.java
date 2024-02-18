package com.example.finalproject.BottomNavigationBar.PlanMeals.preseneter;

import android.util.Log;

import com.example.finalproject.BottomNavigationBar.PlanMeals.view.PlanView;
import com.example.finalproject.model.MealPlan;
import com.example.finalproject.model.MealsRepository;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PlanPreseneterImp implements PlanPreseneter{
    private PlanView view;
    private MealsRepository repo;
    private static final String TAG = "PlanPreseneterImp";

    public PlanPreseneterImp(PlanView view, MealsRepository repo) {
        this.view = view;
        this.repo = repo;
    }

    @Override
    public void removeFromPlan(MealPlan plan) {
        repo.deletePlan(plan)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> view.removePlan(plan),
                        error -> Log.i(TAG, "removeFromPlan: Error")
                );
    }

    @Override
    public void getStoredPlans() {
        repo.getStoredPlans()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(plans -> {
                    view.allPlans(plans);
                });
    }
}
