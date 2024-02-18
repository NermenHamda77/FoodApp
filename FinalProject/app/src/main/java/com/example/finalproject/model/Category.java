package com.example.finalproject.model;

public class Category {
   String strCategory;
   String strCategoryThumb;

   public Category(){

   }

    public Category(String strCategory, String strCategoryThumb) {
        this.strCategory = strCategory;
        this.strCategoryThumb = strCategoryThumb;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }


    public String getStrCategoryThumb() {
        return strCategoryThumb;
    }

    public void setStrCategoryThumb(String strCategoryThumb) {
        this.strCategoryThumb = strCategoryThumb;
    }

    @Override
    public String toString() {
        return "Category{" +
                "strCategory='" + strCategory + '\'' +
                ", strCategoryDescription='" + '\'' +
                ", strCategoryThumb='" + strCategoryThumb + '\'' +
                '}';
    }
}
