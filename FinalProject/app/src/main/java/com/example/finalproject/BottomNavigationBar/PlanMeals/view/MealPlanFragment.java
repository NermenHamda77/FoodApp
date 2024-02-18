package com.example.finalproject.BottomNavigationBar.PlanMeals.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalproject.BottomNavigationBar.PlanMeals.preseneter.PlanPreseneterImp;
import com.example.finalproject.Network.RemoteDataSourceAPI;
import com.example.finalproject.R;
import com.example.finalproject.db.MealLocalDataSourceImp;
import com.example.finalproject.model.MealPlan;
import com.example.finalproject.model.MealsRepositoryImp;

import java.util.ArrayList;
import java.util.List;

public class MealPlanFragment extends Fragment implements PlanView{
    RecyclerView planRecycler;
    PlanAdapter planAdapter;
    RecyclerView.LayoutManager layoutManager;
    PlanPreseneterImp planPreseneterImp;



    public MealPlanFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_meal_plan, container, false);
        planRecycler = view.findViewById(R.id.rv_plan_list);
        planAdapter = new PlanAdapter( new ArrayList<>(),getActivity() ,this);
        layoutManager = new LinearLayoutManager(getActivity() , RecyclerView.VERTICAL , false);;
        planRecycler.setLayoutManager(layoutManager);
        planRecycler.setAdapter(planAdapter);

        planPreseneterImp = new PlanPreseneterImp(this, MealsRepositoryImp.getInstance(RemoteDataSourceAPI.getInstance() , MealLocalDataSourceImp.getInstance(getActivity())));
        planPreseneterImp.getStoredPlans();
        return view;
    }

    @Override
    public void removePlan(MealPlan plan) {
        planPreseneterImp.removeFromPlan(plan);
        //planAdapter.notifyDataSetChanged();
        //plan.clear();
    }

    @Override
    public void allPlans(List<MealPlan> plans) {
        planAdapter.setList(plans);
        planAdapter.notifyDataSetChanged();

    }
}

