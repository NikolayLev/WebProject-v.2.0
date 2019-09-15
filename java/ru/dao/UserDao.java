package ru.dao;

import ru.models.User;

import java.util.Optional;

public interface UserDao extends CrudDao<User> {
    public Optional<User> findUserByName(String name);
    public void deleteByName(String name);

}
