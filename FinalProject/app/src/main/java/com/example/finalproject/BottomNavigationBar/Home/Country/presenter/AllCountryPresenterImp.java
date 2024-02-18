package com.example.finalproject.BottomNavigationBar.Home.Country.presenter;

import com.example.finalproject.BottomNavigationBar.Home.Country.view.AllCountryView;
import com.example.finalproject.model.CountryResponse;
import com.example.finalproject.model.MealResponse;
import com.example.finalproject.model.MealsRepository;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class AllCountryPresenterImp implements AllCCountryPresenter{
    private AllCountryView view;
    private MealsRepository mealsRepository;
    private static final String TAG = "AllCCountryPresenterImp";
    public AllCountryPresenterImp(AllCountryView view, MealsRepository mealsRepository) {
        this.view = view;
        this.mealsRepository = mealsRepository;
    }

    @Override
    public void getAllCountries() {
        Observable<CountryResponse> observable = mealsRepository.getAllCountries();
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CountryResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull CountryResponse countryResponse) {
                        view.showCountryData(countryResponse.getCountries());

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.showCountryErrMsg("Error" + e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

  /*  @Override
    public void getCountryName(String countryName) {
        Observable<MealResponse> observable = mealsRepository.getByCountryName(countryName);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MealResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull MealResponse mealResponse) {
                          view.getCountryName(mealResponse.getMeals());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }*/
}


/*
public class AllCategoryPresenterImp implements AllCategoryPreseneter {
    private AllCategoryView view;
    private MealsRepository mealsRepository;
    private static final String TAG = "AllCategoryPresenterImp";
/*

   private AllProductsView view;

    private ProductRepository productRepository;
    private static final String TAG = "AllProductsPresenterImp";
 *//*
public AllCategoryPresenterImp(AllCategoryView view, MealsRepository mealsRepository) {
    this.view = view;
    this.mealsRepository = mealsRepository;
}
    @Override
    public void getAllCategories() {
        Observable<CategoryResponse> observable = mealsRepository.getAllCategoriess();
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CategoryResponse>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull CategoryResponse categoryResponse) {
                        view.showData(categoryResponse.getCategories());

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.showErrMsg("Error");

                    }

                    @Override
                    public void onComplete() {

                    }
                });



    }


}
 */