package com.example.finalproject.BottomNavigationBar.Search.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalproject.BottomNavigationBar.Search.presenter.AllMealsPresenter;
import com.example.finalproject.BottomNavigationBar.Search.presenter.AllMealsPresenterImp;
import com.example.finalproject.Network.RemoteDataSourceAPI;
import com.example.finalproject.R;
import com.example.finalproject.db.MealLocalDataSourceImp;
import com.example.finalproject.model.Meal;
import com.example.finalproject.model.MealsRepositoryImp;

import java.util.ArrayList;
import java.util.List;


public class SearchhFragment extends Fragment implements AllMealsView{

    EditText editText_SearchByName;
    RecyclerView recyclerView_SearchByName;
    LinearLayoutManager linearLayoutManager;
    SearchAdapter searchAdapter;
    AllMealsPresenter allMealsPresenter;
    List<Meal> meals;

    public SearchhFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_searchh, container, false);

        editText_SearchByName = view.findViewById(R.id.et_search_by_name);
        recyclerView_SearchByName = view.findViewById(R.id.recyclerView_search_by_name);

        searchAdapter = new SearchAdapter(getContext(), new ArrayList<>(), this);
        recyclerView_SearchByName.setAdapter(searchAdapter);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView_SearchByName.setLayoutManager(linearLayoutManager);
        editText_SearchByName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Log.i(TAG, "beforeTextChanged: ");
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //   Log.i(TAG, "onTextChanged: ");
            }
            @Override
            public void afterTextChanged(Editable s) {
                //  Log.i(TAG, "afterTextChanged: ");
                searchAdapter.getFilter().filter(s);
            }
        });

        //Presenter
        allMealsPresenter = new AllMealsPresenterImp(this, MealsRepositoryImp.getInstance(RemoteDataSourceAPI.getInstance(), MealLocalDataSourceImp.getInstance(getContext())));

        allMealsPresenter.getMeals();

        return view;
    }

    @Override
    public void showData(List<Meal> meals) {
        searchAdapter.setList(meals);
        searchAdapter.notifyDataSetChanged();
    }


    @Override
    public void showMsg(String error) {
        Toast.makeText(getContext(), "Error" + error, Toast.LENGTH_SHORT).show();
    }
}