package com.andersen.training.crud.interfaces;

import java.util.List;

public interface CrudService<T> {
    public void create(T dto);

    public List<T> readAll();

    public T readById(int id);

    public void update(int id, T dto);

    public void delete(int id);
}
