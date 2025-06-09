package com.myspringboot.test.TTypeToken;

import com.myspringboot.test.TTypeToken.factory.ListFactory;
import com.myspringboot.test.TTypeToken.factory.StringFactory;
import com.myspringboot.test.TTypeToken.token.SuperTypeToken;
import com.myspringboot.test.TTypeToken.token.TypeSafeContainer;
import com.myspringboot.test.TTypeToken.token.TypeToken;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

// =================== 5. 测试和演示 ===================
public class TypeTokenDemo {
    public static void main(String[] args) {

        // === 基础类型令牌演示 ===
        System.out.println("=== 基础类型令牌 ===");
        TypeToken<String> stringToken = new TypeToken<>(String.class);
        TypeToken<Integer> intToken = new TypeToken<>(Integer.class);

        System.out.println("String类型: " + stringToken.getType());
        System.out.println("Integer类型: " + intToken.getType());

        // === 超类型令牌演示 ===
        System.out.println("\n=== 超类型令牌 ===");

        // 匿名内部类方式创建
        SuperTypeToken<List<String>> listStringToken = new SuperTypeToken<List<String>>() {};
        SuperTypeToken<Map<String, Integer>> mapToken = new SuperTypeToken<Map<String, Integer>>() {};

        System.out.println("List<String>类型: " + listStringToken.getType());
        System.out.println("原始类型: " + listStringToken.getRawType());
        System.out.println("Map<String,Integer>类型: " + mapToken.getType());

        // === 类型安全容器演示 ===
        System.out.println("\n=== 类型安全容器 ===");
        TypeSafeContainer container = new TypeSafeContainer();

        container.put(String.class, "Hello");
        container.put(Integer.class, 42);
        container.put(List.class, Arrays.asList("a", "b", "c"));

        String str = container.get(String.class);
        Integer num = container.get(Integer.class);
        List<?> list = container.get(List.class);

        System.out.println("字符串: " + str);
        System.out.println("数字: " + num);
        System.out.println("列表: " + list);

        // === 泛型工厂演示 ===
        System.out.println("\n=== 泛型工厂 ===");
        StringFactory stringFactory = new StringFactory();
        ListFactory<String> listFactory = new ListFactory<>(String.class);

        String created = stringFactory.create();
        List<String> createdList = listFactory.create();

        System.out.println("创建的字符串: " + created);
        System.out.println("创建的列表类型: " + listFactory.getType());
        System.out.println("元素类型: " + listFactory.getElementType());
    }
}
