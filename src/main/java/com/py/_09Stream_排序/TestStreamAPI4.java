package com.py._09Stream_排序;

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
public class TestStreamAPI4 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.99),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 1, 7777.77),
            new Employee("田七", 2, 7777.77),
            new Employee("田七", 3, 7777.77)
    );


    //中间操作
    /**
     * 排序
     * sorted()——自然排序(Comparable.compareTo)
     * sorted(Comparator com)——定制排序(Comparator.compare)
     */

    @Test
    public void test1(){
        List<String> list = Arrays.asList("bbb","aaa","ccc","eee","ddd");
        list.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("----------------------------------");

        employees.stream()
                .sorted((e1,e2) -> {
                    if(e1.getAge() == e2.getAge()){
                        return e1.getName().compareTo(e2.getName());
                    }else{
                        return -Integer.compare(e1.getAge(),e2.getAge());
                    }
                }).forEach(System.out::println);
    }



}