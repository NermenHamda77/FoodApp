package com.example.finalproject.db;

import android.content.Context;

import com.example.finalproject.model.Meal;
import com.example.finalproject.model.MealPlan;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MealLocalDataSourceImp implements MealLocalDataSource {
   private MealDAO dao;
   private PlanDAO planDAO;
   private static MealLocalDataSourceImp localSource;

   private MealLocalDataSourceImp(Context context) {
      AppDataBase db = AppDataBase.getInstance(context.getApplicationContext());
      dao = db.getAllMeals();
      planDAO = db.getAllPlans();
   }

   public static MealLocalDataSourceImp getInstance(Context context) {
      if (localSource == null) {
         synchronized (MealLocalDataSourceImp.class){
            if (localSource == null){
               localSource = new MealLocalDataSourceImp(context);

            }
         }
      }

      return localSource;
   }

   @Override
   public Completable insertMeal(Meal meals) {
      Completable completable = dao.insertMeal(meals).subscribeOn(Schedulers.io());
      return completable;
   }

   @Override
   public Completable deleteMeal(Meal meals) {
      return dao.deleteMeal(meals).subscribeOn(Schedulers.io());
   }

   @Override
   public Flowable<List<Meal>> getAllStoredMeals() {
      return dao.getAllMeals().subscribeOn(Schedulers.io());
   }


   /////
   @Override
   public Completable deletePlan(MealPlan plans) {
      return planDAO.deletePlan(plans).subscribeOn(Schedulers.io());
   }

   @Override
   public Flowable<List<MealPlan>> getAllStoredPlans() {

      return planDAO.getAllPlans().subscribeOn(Schedulers.io());
   }

   @Override
   public Completable insertPlanInLocal(MealPlan plan) {
      return planDAO.insertPlan(plan).subscribeOn(Schedulers.io());
   }






}