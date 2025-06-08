package com.myspringboot.springboottest1.test2.controller;

import com.myspringboot.springboottest1.test2.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 4. 使用
@RestController
public class NotificationController {

    @Autowired
    private EmailService emailService;  // Spring自动注入我们配置的EmailService

    @PostMapping("/send-notification")
    public String sendNotification(@RequestParam String email) {
        emailService.sendEmail(email, "通知", "这是一条通知消息");
        return "邮件发送成功";
    }
}
