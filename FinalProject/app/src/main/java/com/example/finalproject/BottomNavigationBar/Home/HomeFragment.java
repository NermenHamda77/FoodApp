package com.example.finalproject.BottomNavigationBar.Home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.BottomNavigationBar.Authentication.LoginActivity;
import com.example.finalproject.BottomNavigationBar.Home.Country.presenter.AllCountryPresenterImp;
import com.example.finalproject.BottomNavigationBar.Home.Country.view.AllCountryView;
import com.example.finalproject.BottomNavigationBar.Home.Country.view.RecyclerviewCountryAdapter;
import com.example.finalproject.BottomNavigationBar.Home.RandomMeal.presenter.RandomMealsPreseneterImp;
import com.example.finalproject.BottomNavigationBar.Home.RandomMeal.view.OnMealClickListener;
import com.example.finalproject.BottomNavigationBar.Home.RandomMeal.view.RandomMealView;
import com.example.finalproject.BottomNavigationBar.Home.RandomMeal.view.RandomMealsAdapter;
import com.example.finalproject.Network.RemoteDataSourceAPI;
import com.example.finalproject.R;
import com.example.finalproject.StartActivity;
import com.example.finalproject.db.MealLocalDataSourceImp;
import com.example.finalproject.model.Country;
import com.example.finalproject.model.Meal;
import com.example.finalproject.model.MealsRepositoryImp;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements OnMealClickListener, RandomMealView, AllCountryView {
    private static final String TAG = "HomeFragment";
    //Random
    RecyclerView recyclerViewRandom;
    RandomMealsAdapter randomMealsAdapter;
    LinearLayoutManager layoutManager;
    RandomMealsPreseneterImp randomMealsPreseneterImp;

    // Country
    RecyclerView recyclerViewCountry;
    RecyclerviewCountryAdapter countryAdapter;
    AllCountryPresenterImp countryPresenterImp;


   ImageView logoutImage;
    SharedPreferences mySavedData;
    SharedPreferences.Editor mySavedDataEditor;

    public HomeFragment() {
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //Random Meals
        recyclerViewRandom = view.findViewById(R.id.rv_home_random);
        randomMealsAdapter = new RandomMealsAdapter(new ArrayList<>(), getActivity(), this);
        recyclerViewRandom.setAdapter(randomMealsAdapter);
        layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        recyclerViewRandom.setLayoutManager(layoutManager);
        randomMealsPreseneterImp = new RandomMealsPreseneterImp(this, MealsRepositoryImp.getInstance(RemoteDataSourceAPI.getInstance(), MealLocalDataSourceImp.getInstance(getActivity())));
        randomMealsPreseneterImp.getRandomMeal();


        logoutImage = view.findViewById(R.id.iv_logout);
        logoutImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mySavedData = getActivity().getSharedPreferences(LoginActivity.PREFS_NAME, 0);
                mySavedDataEditor = mySavedData.edit();
                mySavedDataEditor.putBoolean("hasLoggedIn", false);
                mySavedDataEditor.apply();


                Intent intent = new Intent(getActivity(), StartActivity.class);
                startActivity(intent);
                requireActivity().finish();

                Log.i(TAG, "onClick: in logout" );
            }
        });




        //Country List
        recyclerViewCountry = view.findViewById(R.id.rv_home_country);
        countryAdapter = new RecyclerviewCountryAdapter(new ArrayList<>(), getActivity());
        recyclerViewCountry.setAdapter(countryAdapter);
        RecyclerView.LayoutManager layoutManager2 = new GridLayoutManager(getActivity(), 3);
        recyclerViewCountry.setLayoutManager(layoutManager2);
        countryPresenterImp = new AllCountryPresenterImp(this, MealsRepositoryImp.getInstance(RemoteDataSourceAPI.getInstance(), MealLocalDataSourceImp.getInstance(getActivity())));
        countryPresenterImp.getAllCountries();



        return view;
    }

    // click listener
    @Override
    public void onMealClick(Meal meals) {
        Toast.makeText(getActivity(), "Add To fav Successfully", Toast.LENGTH_SHORT).show();
        addMeal(meals);
    }

    @Override
    public void showCountryData(List<Country> meals) {
        countryAdapter.setCountry(meals);
        countryAdapter.notifyDataSetChanged();
    }

    @Override
    public void showCountryErrMsg(String error) {
        Toast.makeText(getActivity(), "Error" + error, Toast.LENGTH_SHORT).show();

    }


    @Override
    public void showMealData(List<Meal> meals) {
        randomMealsAdapter.setMeal(meals);
        randomMealsAdapter.notifyDataSetChanged();

    }

    @Override
    public void showMealMsg(String error) {
        Toast.makeText(getActivity(), "Error" + error, Toast.LENGTH_SHORT).show();

    }

    // add to fav
    @Override
    public void addMeal(Meal meals) {
        randomMealsPreseneterImp.addToFav(meals);

    }

}


