package ru.dao;

import ru.models.User;
import ru.models.UserProduct;

import java.util.List;

public interface UserProductDao extends CrudDao<UserProduct> {
    public List<UserProduct> findUserProduct(User user);

}
