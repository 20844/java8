package com.py._06创建Stream;

import com.py._01为什么使用Lamda表达式.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一、Stream 的三个操作步骤：
 *
 * 1. 创建 Stream
 *
 * 2. 中间操作
 *
 * 3. 终止操作（终端操作）
 */
public class TestStreamAPI1 {

    // 1. 创建 Stream
    @Test
    public void test1() {
        //1. 可以通过 Collection 系列集合提供的 stream() 或 parallelStream()
        ArrayList<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();//获取一个顺序流
        Stream<String> stream2 = list.parallelStream();//获取一个并行流

        //2. 通过 Arrays 中的静态方法 stream() 获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream3 = Arrays.stream(emps);

        //3. 通过 Stream 类中的静态方法 of()
        Stream<String> stream4 = Stream.of("aa", "bb", "cc");

        //4. 创建无限流
        //迭代
        Stream<Integer> stream5 = Stream.iterate(0, (x) -> x + 2);
        stream5.limit(10).forEach(System.out::println);
        //生成
        Stream.generate(() -> Math.random())
                .limit(5)
                .forEach(System.out::println);


    }
}
