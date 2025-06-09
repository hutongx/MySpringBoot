package com.myspringboot.test.TTypeGeneric;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

// =================== 2. 方法泛型信息获取 ===================
class MethodGenericsAnalyzer {

    // 测试方法：各种泛型签名
    public <T> T genericMethod(T param) { return param; }

    public <T extends Number> T boundedGeneric(T param) { return param; }

    public <T, R> R convert(T input, Class<R> targetType) { return null; }

    public List<String> getStringList() { return null; }

    public void processMap(Map<String, ? extends Number> map) {}

    public static void analyzeMethod(String methodName, Class<?>... paramTypes) {
        try {
            Method method = MethodGenericsAnalyzer.class.getDeclaredMethod(methodName, paramTypes);

            System.out.println("\n=== 分析方法: " + methodName + " ===");

            // 方法级别的类型变量
            TypeVariable<Method>[] typeParameters = method.getTypeParameters();
            System.out.println("方法类型参数: " + Arrays.toString(typeParameters));

            // 返回类型
            Type returnType = method.getGenericReturnType();
            System.out.println("返回类型: " + returnType);
            ReflectionBasics.analyzeType(returnType);

            // 参数类型
            Type[] parameterTypes = method.getGenericParameterTypes();
            System.out.println("参数类型:");
            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.println("  参数" + i + ": " + parameterTypes[i]);
                ReflectionBasics.analyzeType(parameterTypes[i]);
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
