package com.example.finalproject.BottomNavigationBar.Category.presenter;
import com.example.finalproject.BottomNavigationBar.Category.view.AllCategoryView;
import com.example.finalproject.model.CategoryResponse;

import com.example.finalproject.model.MealsRepository;


import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class AllCategoryPresenterImp implements AllCategoryPreseneter {
    private AllCategoryView view;
    private MealsRepository mealsRepository;
    private static final String TAG = "AllCategoryPresenterImp";
/*

   private AllProductsView view;

    private ProductRepository productRepository;
    private static final String TAG = "AllProductsPresenterImp";
 */
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
                        view.showErrMsg("Error" + e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });



    }


}


