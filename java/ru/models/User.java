package ru.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "User")
@Table(name = "project_user")
public class User implements Serializable  {
    @Column(name ="name", unique = true)
    private String name;
    @Column(name ="password")
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<UserProduct> userProductList;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
