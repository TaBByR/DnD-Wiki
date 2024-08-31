package io.henriqueceleste.dndwiki.service;

import java.util.List;

public interface Service<T> {
    T get(Integer id);
}
