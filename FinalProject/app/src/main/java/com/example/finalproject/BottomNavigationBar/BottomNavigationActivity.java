package com.example.finalproject.BottomNavigationBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.finalproject.BottomNavigationBar.Category.view.CategoryFragment1;
import com.example.finalproject.BottomNavigationBar.FavoriteMeals.view.FavoriteFragment;
import com.example.finalproject.BottomNavigationBar.Home.HomeFragment;
import com.example.finalproject.BottomNavigationBar.PlanMeals.view.MealPlanFragment;
import com.example.finalproject.BottomNavigationBar.Search.view.SearchFragment;
import com.example.finalproject.R;
import com.example.finalproject.databinding.ActivityBottomNavigationBinding;

public class BottomNavigationActivity extends AppCompatActivity {
    ActivityBottomNavigationBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBottomNavigationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        replaceFragments(new HomeFragment());
        binding.bottomNavigationView.setBackground(null);
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home_id) {
                replaceFragments(new HomeFragment());
            }
            else if (item.getItemId() == R.id.category_id) {
                replaceFragments(new CategoryFragment1());
            }
            else if (item.getItemId() == R.id.meal_plan_id) {
                replaceFragments(new MealPlanFragment());
            }
            else if (item.getItemId() == R.id.search_id) {
                replaceFragments(new SearchFragment());
            }
            else if (item.getItemId() == R.id.fav_id) {
                replaceFragments(new FavoriteFragment());
            }
            return true;
        });

    }
    private void replaceFragments(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout , fragment);
        fragmentTransaction.commit();
    }

}

