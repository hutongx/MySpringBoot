package com.myspringboot.test.TAnnotationReflect.MyAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Validate {
    String pattern() default "";
    int min() default Integer.MIN_VALUE;
    int max() default Integer.MAX_VALUE;
    boolean notNull() default false;
}
