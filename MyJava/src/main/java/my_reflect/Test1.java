package my_reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Test1 {

    public static void main(String[] args) throws ClassNotFoundException {
        // 1. Class类 - 代表一个类或接口
        Class<?> clazz = String.class;
        Class<?> clazz2 = Class.forName("java.lang.String");

        // 2. Field类 - 代表类的字段
        Field[] fields = clazz.getDeclaredFields();

        // 3. Method类 - 代表类的方法
        Method[] methods = clazz.getDeclaredMethods();

        // 4. Constructor类 - 代表类的构造器
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        Arrays.stream(fields).forEach(
            field -> System.out.println("Field: " + field.getName() + ", Type: " + field.getType())
        );

        Arrays.stream(methods).forEach(
            method -> System.out.print("Method: " + method.getName() + ", Return Type: " + method.getReturnType())
        );
        System.out.println();
        Arrays.stream(constructors).forEach(
            constructor -> System.out.println("Constructor: " + constructor.getName() + ", Parameter Count: " + constructor.getParameterCount())
        );
    }
}
