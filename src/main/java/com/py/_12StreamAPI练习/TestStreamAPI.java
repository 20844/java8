package com.py._12StreamAPI练习;

import com.py._01为什么使用Lamda表达式.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestStreamAPI {
    /**
     * 1.给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
     * 给定1，,2，,3，,4，,5应该返回1，,4，,9，,16，,25
     */
    @Test
    public void test(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = list.stream()
                .map(e -> e * e)
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }



    List<Employee> employees = Arrays.asList(
            new Employee("张三",18,9999.99),
            new Employee("李四",38,5555.99),
            new Employee("王五",50,6666.66),
            new Employee("赵六",16,3333.33),
            new Employee("田七",8,7777.77)
    );

    /**
     * 怎么用map和reduce方法数一数流中有多少个Employee呢？
     */
    @Test
    public void test2(){
        System.out.println(employees.stream().count());

        Optional<Integer> reduce = employees.stream()
                .map(e -> 1)
                .reduce(Integer::sum);
        System.out.println(reduce.get());

    }


}
