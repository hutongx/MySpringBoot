package com.myspringboot.springboottest1.test1.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getAllUsers() {
        return "List of users";
    }
}
