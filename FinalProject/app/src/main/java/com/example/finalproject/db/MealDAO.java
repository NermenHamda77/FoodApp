package com.example.finalproject.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.finalproject.model.Meal;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface MealDAO {
    @Query("SELECT * From meal_table")
    Flowable<List<Meal>> getAllMeals();
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insertMeal(Meal meals);

    @Delete
    Completable deleteMeal(Meal meals);


}