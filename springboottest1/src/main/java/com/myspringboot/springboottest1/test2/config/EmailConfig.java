package com.myspringboot.springboottest1.test2.config;

import com.myspringboot.springboottest1.test2.service.EmailService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 3. 配置类
@Configuration
@EnableConfigurationProperties(EmailProperties.class)
public class EmailConfig {

    @Bean
    public EmailService emailService(EmailProperties emailProps) {
        return new EmailService(
                emailProps.getHost(),
                emailProps.getPort(),
                emailProps.getUsername(),
                emailProps.getPassword(),
                emailProps.isEnableSsl()
        );
    }
}
