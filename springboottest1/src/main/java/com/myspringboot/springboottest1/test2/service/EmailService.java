package com.myspringboot.springboottest1.test2.service;

import org.springframework.stereotype.Service;

// 2. 服务类
@Service
public class EmailService {
    private final String host;
    private final int port;
    private final String username;
    private final String password;
    private final boolean enableSsl;

    public EmailService(String host, int port, String username, String password, boolean enableSsl) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.enableSsl = enableSsl;
        System.out.println("EmailService创建完成，配置：" + host + ":" + port);
    }

    public void sendEmail(String to, String subject, String content) {
        System.out.println("发送邮件到：" + to + "，主题：" + subject);
    }
}
