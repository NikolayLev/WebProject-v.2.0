package ru.models;

import javax.persistence.*;

@Entity(name = "UserProduct")
@Table(name ="project_product")
public class UserProduct {
    @Column(name = "name")
    private String productName;
    @Column(name = "price")
    private int price;
    @ManyToOne
    @JoinColumn(name = "user_name", referencedColumnName = "name")
    private User user;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;



    public UserProduct() {
    }

    public UserProduct(String productName, int price, User user) {
        this.productName = productName;
        this.price = price;
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserProduct{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                '}';
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

    public User getUser() {
        return user;
    }

    public void setUser(String userName) {
        this.user = user;
    }

    public int getPrice() {
        return price;
    }
}
