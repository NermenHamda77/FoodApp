package com.example.finalproject.BottomNavigationBar.Category.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.finalproject.BottomNavigationBar.Category.presenter.AllCategoryPresenterImp;
import com.example.finalproject.Network.RemoteDataSourceAPI;
import com.example.finalproject.R;
import com.example.finalproject.db.MealLocalDataSourceImp;
import com.example.finalproject.model.Category;
import com.example.finalproject.model.MealsRepositoryImp;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment1 extends Fragment implements AllCategoryView {
    private static final String TAG = "CategoryFragment1";
    RecyclerView recyclerView;
    CategoryAdapter categoryAdapter;
    AllCategoryPresenterImp presenterImp;
    
    public CategoryFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_category1, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewFrag);
        categoryAdapter = new CategoryAdapter(new ArrayList<>(), getActivity()   );
        recyclerView.setAdapter(categoryAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity() , 2));
        presenterImp = new AllCategoryPresenterImp(this, MealsRepositoryImp.getInstance(RemoteDataSourceAPI.getInstance(), MealLocalDataSourceImp.getInstance(getActivity())));
        presenterImp.getAllCategories();
        Log.i(TAG, "onCreateView: view");
        return view;

    }

    @Override
    public void showData(List<Category> categories) {
        categoryAdapter.setCategory(categories);
        categoryAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrMsg(String error) {
        Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();

    }


}
