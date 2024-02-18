package com.example.finalproject.BottomNavigationBar.PlanMeals.view;

import com.example.finalproject.model.Meal;
import com.example.finalproject.model.MealPlan;

import java.util.List;

public interface PlanView {
        public void removePlan(MealPlan plan);

        public void allPlans(List<MealPlan> plans);


}
