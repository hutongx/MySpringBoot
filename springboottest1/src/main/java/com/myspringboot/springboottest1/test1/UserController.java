package com.myspringboot.springboottest1.test1;

import com.myspringboot.springboottest1.Springboottest1Application;
import com.myspringboot.springboottest1.test1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;  // Spring从容器中取出userService对象注入

//    private final UserService userService;
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @GetMapping("/users")
    public String getUsers() {
        return userService.getAllUsers();
    }

    public static void main(String[] args) {
//        UserService userService1 = new UserService();
//        UserController userController = new UserController(userService1);
//        System.out.println(userController.getUsers());

        ConfigurableApplicationContext ctx = SpringApplication.run(Springboottest1Application.class, args);
        UserController userController = ctx.getBean(UserController.class);
        System.out.println(userController.getUsers());
    }
}
