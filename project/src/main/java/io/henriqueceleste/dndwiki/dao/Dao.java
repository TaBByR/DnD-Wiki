package io.henriqueceleste.dndwiki.dao;

import java.util.List;

public interface Dao<T> {
    T findById(Integer id);
    List<T> findAll();
}
