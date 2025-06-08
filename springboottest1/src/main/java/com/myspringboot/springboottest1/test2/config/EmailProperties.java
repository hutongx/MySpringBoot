package com.myspringboot.springboottest1.test2.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

// 1. 配置属性
@ConfigurationProperties(prefix = "myapp.email")
public class EmailProperties {
    public String host;
    public int port;
    public String username;
    public String password;
    public boolean enableSsl;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnableSsl() {
        return enableSsl;
    }

    public void setEnableSsl(boolean enableSsl) {
        this.enableSsl = enableSsl;
    }
}
