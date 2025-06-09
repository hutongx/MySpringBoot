package com.myspringboot.test.TDao;

import java.util.List;

// 第一步：定义一个通用的数据访问接口
public interface SimpleDao<T> {
    void save(T item);
    T findById(int id);
    List<T> findAll();
}
