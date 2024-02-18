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
    /*BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    CategoryFragment categoryFragment = new CategoryFragment();
    SearchFragment searchFragment = new SearchFragment();
    MealPlanFragment mealPlanFragment = new MealPlanFragment();
    AddNewMealFragment addNewMealFragment = new AddNewMealFragment();*/

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


/*
  binding = ActivityBottomNavigationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //replaceFragments(new HomeFragment());
        binding.bottomNavigationView.setBackground(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    replaceFragments(new HomeFragment());
                    break;
                case R.id.category:
                    replaceFragments(new CategoryFragment());
                    break;
                case R.id.fab:
                    replaceFragments(new AddNewMealFragment());
                    break;
                case R.id.meal_plan:
                    replaceFragments(new MealPlanFragment());
                    break;
                case R.id.search:
                    replaceFragments(new SearchFragment());
                    break;
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
 */


        /*setContentView(R.layout.activity_bottom_navigation);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout , homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                if (item.getItemId() == R.id.home_id) {
                    replaceFragments(new HomeFragment());
                }
                else if (item.getItemId() == R.id.category_id) {
                    replaceFragments(new CategoryFragment());
                }
                else if (item.getItemId() == R.id.meal_plan_id) {
                    replaceFragments(new MealPlanFragment());
                }
                else if (item.getItemId() == R.id.fab_id) {
                    replaceFragments(new AddNewMealFragment());
                }
                else if (item.getItemId() == R.id.fab_id) {
                    replaceFragments(new SearchFragment());
                }
                return true;
            }
        });*/