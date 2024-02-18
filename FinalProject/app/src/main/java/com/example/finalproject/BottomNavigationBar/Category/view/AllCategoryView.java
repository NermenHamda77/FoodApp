package com.example.finalproject.BottomNavigationBar.Category.view;

import com.example.finalproject.model.Category;

import java.util.List;

public interface AllCategoryView {
    public void showData(List<Category> products);    // AllProductActivity(view) needs to show data
    public void showErrMsg(String error);

}
