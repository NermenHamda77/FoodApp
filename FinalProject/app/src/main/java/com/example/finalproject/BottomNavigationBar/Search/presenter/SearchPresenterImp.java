package com.example.finalproject.BottomNavigationBar.Search.presenter;

import com.example.finalproject.BottomNavigationBar.Search.view.SearchView;
import com.example.finalproject.model.CategoryResponse;
import com.example.finalproject.model.CountryResponse;
import com.example.finalproject.model.IngredientResponse;
import com.example.finalproject.model.MealsRepository;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class SearchPresenterImp implements SearchPresenter {
    SearchView view;
    private MealsRepository repo;
    private static final String TAG = "SearchPresenterImp";

    public SearchPresenterImp(SearchView view, MealsRepository repo) {
        this.view = view;
        this.repo = repo;
    }


    /**
     *
     */
    @Override
    public void getCategories() {
        Observable<CategoryResponse> observable = repo.getAllCategoriess();
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CategoryResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull CategoryResponse categoryResponse) {
                        view.showCategories(categoryResponse.getCategories());

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.showMsg("Error" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     *
     */
    @Override
    public void getCountries() {
        Observable<CountryResponse> observable = repo.getAllCountries();
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CountryResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull CountryResponse countryResponse) {
                        view.showCountries(countryResponse.getCountries());

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.showMsg("Error" + e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    @Override
    public void getIngrediants(String categoryName) {
        Observable<IngredientResponse> observable = repo.getAllIngredients(categoryName);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<IngredientResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull IngredientResponse ingredientResponse) {
                          view.showIngredients(ingredientResponse.getIngredients());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                         view.showMsg("Error" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}

