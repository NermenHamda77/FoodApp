package com.example.finalproject.BottomNavigationBar.Search.view;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.finalproject.BottomNavigationBar.Search.presenter.SearchPresenterImp;
import com.example.finalproject.Network.RemoteDataSourceAPI;
import com.example.finalproject.R;
import com.example.finalproject.db.MealLocalDataSourceImp;
import com.example.finalproject.model.Category;
import com.example.finalproject.model.Country;
import com.example.finalproject.model.Ingredient;
import com.example.finalproject.model.MealsRepositoryImp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Predicate;

public class SearchFragment extends Fragment implements SearchView{
    List<String> categoriesName = new ArrayList<>();
    List<String> countriesName =  new ArrayList<>();

    CategoryAdapter categoryAdapter;
    CountryAdapter countryAdapter;

    EditText etSearch;
    Button btnCategory, btnCountry;
    RecyclerView recyclerView_res;
    LinearLayoutManager linearLayoutManager;

    SearchPresenterImp searchPresenterImp;



    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);



        // id
        recyclerView_res = view.findViewById(R.id.rv_result_search);
        etSearch = view.findViewById(R.id.et_search);
        btnCategory = view.findViewById(R.id.btn_categories_list_search);
        btnCountry = view.findViewById(R.id.btn_countries_list_search);


        // Adapters
        countryAdapter = new CountryAdapter(new ArrayList<>(), getContext());
        categoryAdapter = new CategoryAdapter(new ArrayList<>(), getContext());


        // recyclerView_res.setAdapter(categoryAdapter);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView_res.setLayoutManager(linearLayoutManager);

        // Presenter
        searchPresenterImp = new SearchPresenterImp(this, MealsRepositoryImp.getInstance(RemoteDataSourceAPI.getInstance(),
                MealLocalDataSourceImp.getInstance(getContext())));


        // Buttons Click
        btnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView_res.setAdapter(categoryAdapter);
                searchPresenterImp.getCategories();


                List<Category> categories = categoryAdapter.getCategories();
                categoriesName.clear();
                for (int j = 0; j < categories.size(); j++) {
                    categoriesName.add(categories.get(j).getStrCategory());
                }
            }
        });

        btnCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView_res.setAdapter(countryAdapter);
                searchPresenterImp.getCountries();

                List<Country> countries = countryAdapter.getCountries();
                countriesName.clear();
                for (int i = 0; i < countries.size(); i++) {
                    countriesName.add(countries.get(i).getStrArea());
                }

            }
        });




        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                etSearch.addTextChangedListener(new TextWatcher() {

                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        emitter.onNext(charSequence.toString());
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });
            }
        });

        observable.debounce(300, TimeUnit.MILLISECONDS).filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Throwable {
                        return !s.isEmpty();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        countriesName.clear();
                        for (String name : countriesName) {
                            if (name.toLowerCase().contains(s.toLowerCase())) {
                                countriesName.add(name + "\n");
                               // performSearch(name);
                            }
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });



        return view;

    }


    @Override
    public void showCategories(List<Category> categories) {
        categoryAdapter.setCategory(categories);
        categoryAdapter.notifyDataSetChanged();

    }

    @Override
    public void showCountries(List<Country> meals) {
        countryAdapter.setCountry(meals);
        countryAdapter.notifyDataSetChanged();

    }

    /**
     * @param meals
     */
    @Override
    public void showIngredients(List<Ingredient> meals) {
        //////////////
    }


    @Override
    public void showMsg(String error) {
        Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();

    }

    private void performSearch(String query) {
        if (recyclerView_res.getAdapter() == categoryAdapter) {
            categoryAdapter.filter(query);
        } else if (recyclerView_res.getAdapter() == countryAdapter) {
            countryAdapter.filter(query);
        }
    }



}
