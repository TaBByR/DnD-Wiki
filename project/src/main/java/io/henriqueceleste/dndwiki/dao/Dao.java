package io.henriqueceleste.dndwiki.dao;

public interface Dao<T> {
    T findById(Integer id);
}
