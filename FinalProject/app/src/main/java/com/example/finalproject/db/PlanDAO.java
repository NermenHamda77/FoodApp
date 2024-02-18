package com.example.finalproject.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.finalproject.model.MealPlan;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface PlanDAO {
    @Query("SELECT * From plans_table")
    Flowable<List<MealPlan>> getAllPlans();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insertPlan(MealPlan plan);

    @Delete
    Completable deletePlan(MealPlan plan);

}
/*
@Dao
public interface MyPlanDAO {
    @Query("SELECT * From plans_table")
    Flowable<List<MealPlan>> getAllPlans();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insertPlan(MealPlan plan);

    @Delete
    Completable deletePlan(MealPlan plan);
}
 */