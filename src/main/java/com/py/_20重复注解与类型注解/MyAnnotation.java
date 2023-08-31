package com.py._20重复注解与类型注解;


import java.lang.annotation.*;

@Repeatable(MyContainer.class) //指定容器类
@Target({ElementType.TYPE, ElementType.METHOD,  ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value() default "Java 8";
}
