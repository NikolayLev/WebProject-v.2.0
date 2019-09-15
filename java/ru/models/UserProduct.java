package ru.models;

public class UserProduct {
    private String productName;
    private int price;
    private String userName;


    private UserProduct() {
    }

    public UserProduct(String productName, int price, String userName) {
        this.productName = productName;
        this.price = price;
        this.userName = userName;
    }


    public String getProductName() {
        return productName;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPrice() {
        return price;
    }
}
