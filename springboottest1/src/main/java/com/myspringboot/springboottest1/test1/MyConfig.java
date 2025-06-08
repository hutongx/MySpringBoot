package com.myspringboot.springboottest1.test1;

import com.myspringboot.springboottest1.test1.service.OrderService;
import com.myspringboot.springboottest1.test1.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public UserService userService() {
        System.out.println("创建UserService对象");
        return new UserService();
    }

    @Bean
    public OrderService orderService(UserService userService) {  // 自动注入
        System.out.println("创建OrderService对象，注入UserService");
        return new OrderService(userService);
    }
}
