package com.example.finalproject.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.finalproject.model.Meal;
import com.example.finalproject.model.MealPlan;

@Database(entities = {Meal.class , MealPlan.class}, version = 5)

public abstract class AppDataBase  extends RoomDatabase {
    private static AppDataBase instance = null;
    public abstract MealDAO getAllMeals();
    public abstract PlanDAO getAllPlans();

    public static synchronized AppDataBase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class,"mealdb")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}

