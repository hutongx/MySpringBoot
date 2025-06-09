package my_reflect.test1;

import java.util.Properties;

// 使用示例
public class ConfigExample {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("host", "localhost");
        props.setProperty("port", "3306");
        props.setProperty("username", "admin");
        props.setProperty("password", "123456");

        DatabaseConfig config = ConfigMapper.mapFromProperties(props, DatabaseConfig.class);
        System.out.println("Host: " + config.getHost()); // 输出: Host: localhost
    }
}
