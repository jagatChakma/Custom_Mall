package com.example.mymall;

import java.util.List;

public class HomePageModel {
    public static final int BANNER_SLIDER =0;
    public static final int STRIP_ADD_BANNER = 1;
    public static final int HORIZONTAL_PRODUCT_VIEW = 2;
    public static final int GRID_PRODUCT_VIEW = 3;

    private int type;
    //Banner slider
    private List<SliderModel> sliderModelList;

    public HomePageModel(int type, List<SliderModel> sliderModelList) {
        this.type = type;
        this.sliderModelList = sliderModelList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<SliderModel> getSliderModelList() {
        return sliderModelList;
    }

    public void setSliderModelList(List<SliderModel> sliderModelList) {
        this.sliderModelList = sliderModelList;
    }
    //Strip add
    private int resourse;
    private String backgroundColor;

    public HomePageModel(int type, int resourse, String backgroundColor) {
        this.type = type;
        this.resourse = resourse;
        this.backgroundColor = backgroundColor;
    }

    public int getResourse() {
        return resourse;
    }

    public void setResourse(int resourse) {
        this.resourse = resourse;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
    //Horizontal and grid produce view
    private String title;
    private List<HorizontalProducScrolltModel> horizontalProducScrolltModelList;

    public HomePageModel(int type, String title, List<HorizontalProducScrolltModel> horizontalProducScrolltModelList) {
        this.type = type;
        this.title = title;
        this.horizontalProducScrolltModelList = horizontalProducScrolltModelList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<HorizontalProducScrolltModel> getHorizontalProducScrolltModelList() {
        return horizontalProducScrolltModelList;
    }

    public void setHorizontalProducScrolltModelList(List<HorizontalProducScrolltModel> horizontalProducScrolltModelList) {
        this.horizontalProducScrolltModelList = horizontalProducScrolltModelList;
    }
    //Grid product view

}
