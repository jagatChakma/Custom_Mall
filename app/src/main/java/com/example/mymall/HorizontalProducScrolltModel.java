package com.example.mymall;

public class HorizontalProducScrolltModel {

    private int productImage;
    private String productTitle;
    private String productDiscription;
    private String productPrice;

    public HorizontalProducScrolltModel(int productImage, String productTitle, String productDiscription, String productPrice) {
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.productDiscription = productDiscription;
        this.productPrice = productPrice;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductDiscription() {
        return productDiscription;
    }

    public void setProductDiscription(String productDiscription) {
        this.productDiscription = productDiscription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
