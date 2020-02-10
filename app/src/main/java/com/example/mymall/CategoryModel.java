package com.example.mymall;

public class CategoryModel {
    private String categoryIconLink;
    private String cetegoryName;

    public CategoryModel(String categoryIconLink, String cetegoryName) {
        this.categoryIconLink = categoryIconLink;
        this.cetegoryName = cetegoryName;
    }

    public String getCategoryIconLink() {
        return categoryIconLink;
    }

    public void setCategoryIconLink(String categoryIconLink) {
        this.categoryIconLink = categoryIconLink;
    }

    public String getCetegoryName() {
        return cetegoryName;
    }

    public void setCetegoryName(String cetegoryName) {
        this.cetegoryName = cetegoryName;
    }
}
