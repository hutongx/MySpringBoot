package com.myspringboot.test.TTypeToken.factory;

public class StringFactory implements GenericFactory<String> {
    @Override
    public String create() {
        return "Hello World";
    }

    @Override
    public Class<String> getType() {
        return String.class;
    }
}
