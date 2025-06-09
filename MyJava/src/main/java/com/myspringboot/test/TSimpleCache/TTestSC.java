package com.myspringboot.test.TSimpleCache;

import com.myspringboot.test.TDao.entity.User;

public class TTestSC {
    public static void main(String[] args) throws InterruptedException {
        // 使用
        SimpleCache<String, User> userCache = new SimpleCache<>(5000); // 5秒过期
        userCache.put("user123", new User("张三"));

        User user = userCache.get("user123"); // 5秒内有效
        System.out.println(user.getName());
//        Thread.sleep(7000);
//        User user2 = userCache.get("user123");
//        System.out.println(user2.getName());
    }
}
