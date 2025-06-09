package com.myspringboot.test.TAnnotationReflect.MyAnnotation;


/**
 * 注解+泛型+反射综合应用
 *
 * 这里展示了在实际框架开发中如何组合使用这三大技术：
 * 1. 依赖注入容器
 * 2. ORM框架基础
 * 3. JSON序列化框架
 * 4. 验证框架
 */

import java.lang.annotation.*;

// =================== 1. 核心注解定义 ===================

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Component {
    String value() default "";
}
