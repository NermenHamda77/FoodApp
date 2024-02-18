package com.example.finalproject.BottomNavigationBar.FavoriteMeals.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.finalproject.BottomNavigationBar.FavoriteMeals.presenter.FavoritePresenterImp;
import com.example.finalproject.Network.RemoteDataSourceAPI;
import com.example.finalproject.R;
import com.example.finalproject.db.AppDataBase;
import com.example.finalproject.db.MealDAO;
import com.example.finalproject.db.MealLocalDataSourceImp;
import com.example.finalproject.model.Meal;
import com.example.finalproject.model.MealsRepositoryImp;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public class FavoriteFragment extends Fragment implements FavMealView{

    RecyclerView favRecycler;
    FavoriteAdapter favoriteAdapter;
    RecyclerView.LayoutManager layoutManager;
    FavoritePresenterImp favoritePresenterImp;

    public FavoriteFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_favorite, container, false);
        favRecycler = view.findViewById(R.id.rv_fav_frag);
        favoriteAdapter = new FavoriteAdapter( new ArrayList<>(),getActivity() ,this);
        layoutManager = new LinearLayoutManager(getActivity() , RecyclerView.VERTICAL , false);;
        favRecycler.setLayoutManager(layoutManager);
        favRecycler.setAdapter(favoriteAdapter);

        favoritePresenterImp = new FavoritePresenterImp(this, MealsRepositoryImp.getInstance(RemoteDataSourceAPI.getInstance() , MealLocalDataSourceImp.getInstance(getActivity())));
        favoritePresenterImp.getStoredFav();
        return view;
    }


    @Override
    public void removeMeal(Meal meals) {
        favoritePresenterImp.removeFromFav(meals);
    }

    @Override
    public void allMeals(List<Meal> meals) {
        favoriteAdapter.setList(meals);
        favoriteAdapter.notifyDataSetChanged();

    }
}
