package ru.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class User implements Comparable<User> {
    private String name;
    private String password;
    private List<UserProduct> userProductList;
    private int id;

    public void setUserProductList(List<UserProduct> userProductList) {
        this.userProductList = userProductList;
    }

    public int getId() {
        return id;
    }

    public User(String name, String password, int id) {
        this.name = name;
        this.password = password;
        this.id = id;
        userProductList = new ArrayList<>();
    }
    public User(String name, String password, int id, List<UserProduct> list) {
        this.name = name;
        this.password = password;
        this.id = id;
        userProductList = list;
    }
    public User() {
        userProductList = new ArrayList<>();
    }

    public List<UserProduct> getUserProductList() {
        return userProductList;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        userProductList = new ArrayList<>();
    }

    public User(String name, String password, List<UserProduct> userProductList) {
        this.name = name;
        this.password = password;
        this.userProductList = userProductList;
    }


    @Override
    public int compareTo(User o) {
        return name.compareTo(o.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        return (name.equals(user.name));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setHashPass(String hashPass) {
        this.password = password;
    }


}
