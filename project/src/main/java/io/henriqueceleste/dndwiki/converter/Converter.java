package io.henriqueceleste.dndwiki.converter;

import java.util.List;

public interface Converter<T, R> {
    List<T> convert(List<R> dataList);
    T loadResources(R data);
}
