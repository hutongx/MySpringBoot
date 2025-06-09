package my_reflect.test1;

import java.lang.reflect.Field;
import java.util.Properties;

// 通用配置映射器
public class ConfigMapper {
    public static <T> T mapFromProperties(Properties props, Class<T> clazz) {
        try {
            // 创建目标对象实例
            T instance = clazz.getDeclaredConstructor().newInstance();

            // 获取所有字段
            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                String fieldName = field.getName();
                String propValue = props.getProperty(fieldName);

                if (propValue != null) {
                    field.setAccessible(true); // 允许访问私有字段

                    // 根据字段类型进行类型转换
                    Object convertedValue = convertValue(propValue, field.getType());
                    field.set(instance, convertedValue);
                }
            }

            return instance;
        } catch (Exception e) {
            throw new RuntimeException("配置映射失败", e);
        }
    }

    private static Object convertValue(String value, Class<?> type) {
        if (type == String.class) return value;
        if (type == int.class || type == Integer.class) return Integer.parseInt(value);
        if (type == boolean.class || type == Boolean.class) return Boolean.parseBoolean(value);
        if (type == long.class || type == Long.class) return Long.parseLong(value);
        // 可以扩展更多类型...
        return value;
    }
}
