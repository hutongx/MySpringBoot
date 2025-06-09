package com.myspringboot.test.TTypeGeneric;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// =================== 6. 主演示类 ===================
public class ReflectionGenericsDemo {
    public static void main(String[] args) {

        System.out.println("========== 字段泛型信息分析 ==========");
        ReflectionBasics.analyzeField("stringList");
        ReflectionBasics.analyzeField("stringIntMap");
        ReflectionBasics.analyzeField("numberList");
        ReflectionBasics.analyzeField("integerList");
        ReflectionBasics.analyzeField("genericArray");

        System.out.println("\n========== 方法泛型信息分析 ==========");
        MethodGenericsAnalyzer.analyzeMethod("genericMethod", Object.class);
        MethodGenericsAnalyzer.analyzeMethod("boundedGeneric", Number.class);
        MethodGenericsAnalyzer.analyzeMethod("processMap", Map.class);

        System.out.println("\n========== 实用工具演示 ==========");
        // 获取TestClass的泛型超类信息
        Type[] superTypes = GenericUtils.getSuperclassGenericTypes(TestClass.class);
        System.out.println("TestClass的超类泛型参数: " + Arrays.toString(superTypes));

        // 获取字段的泛型信息
        Type[] nameTypes = GenericUtils.getFieldGenericTypes(TestClass.class, "names");
        System.out.println("names字段的泛型参数: " + Arrays.toString(nameTypes));

        System.out.println("\n========== JSON序列化演示 ==========");
        TestClass testObj = new TestClass();
        String json = SimpleJsonSerializer.serialize(testObj);
        System.out.println("序列化结果: " + json);

        // 序列化复杂对象
        Map<String, List<Integer>> complexMap = new HashMap<>();
        complexMap.put("numbers", Arrays.asList(1, 2, 3));
        complexMap.put("scores", Arrays.asList(95, 87, 92));

        String complexJson = SimpleJsonSerializer.serialize(complexMap);
        System.out.println("复杂对象序列化: " + complexJson);
    }
}
