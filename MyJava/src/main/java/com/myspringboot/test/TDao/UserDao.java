package com.myspringboot.test.TDao;

import com.myspringboot.test.TDao.entity.User;

import java.util.ArrayList;
import java.util.List;

// 第二步：为User实体实现这个接口
public class UserDao implements SimpleDao<User> {
    private List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public User findById(int id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }
}
