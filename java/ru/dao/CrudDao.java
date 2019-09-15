package ru.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDao<T> {
    public Optional<T> find(Integer id);
    public List<T> findAll();
    public void save(T model);
    public void update(T model);
    public void delete(Integer id);
}
