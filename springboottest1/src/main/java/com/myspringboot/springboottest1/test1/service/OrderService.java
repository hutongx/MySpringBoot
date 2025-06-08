package com.myspringboot.springboottest1.test1.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public OrderService(UserService userService) {
        System.out.println("OrderService created with UserService: " + userService);
    }
}
