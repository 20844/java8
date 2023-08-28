package com.py._01为什么使用Lamda表达式;

@FunctionalInterface
public interface MyPredicate<T> {

    public boolean test(T t);
}
