package com.myspringboot.test.TTypeToken.factory;

import java.util.ArrayList;
import java.util.List;

public class ListFactory<T> implements GenericFactory<List<T>> {
    private final Class<T> elementType;

    public ListFactory(Class<T> elementType) {
        this.elementType = elementType;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> create() {
        return new ArrayList<>();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<List<T>> getType() {
        // 这里有局限性，实际返回的是List.class
        return (Class<List<T>>) (Class<?>) List.class;
    }

    public Class<T> getElementType() {
        return elementType;
    }
}
