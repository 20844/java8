package com.py._11Stream_终止操作_归约与收集;

import com.py._01为什么使用Lamda表达式.Employee;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 一、Stream 的三个操作步骤：
 *
 * 1. 创建 Stream
 *
 * 2. 中间操作
 *
 * 3. 终止操作（终端操作）
 */
public class TestStreamAPI6 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Employee.Status.FREE),
            new Employee("李四", 38, 5555.99, Employee.Status.BUSY),
            new Employee("王五", 50, 6666.66,Employee.Status.VOCATION),
            new Employee("赵六", 16, 3333.33,Employee.Status.FREE),
            new Employee("田七", 1, 7777.77,Employee.Status.BUSY),
            new Employee("田七", 1, 7777.77,Employee.Status.BUSY)
    );


    //终止操作
    /**
     * 归约
     * reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
     */
    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Integer sum = list.stream()
                .reduce(0,(x,y) -> x + y);

        System.out.println(sum);

        System.out.println("----------------------------------");

        Optional<Double> op = employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);

        System.out.println(op.get());
    }

    /**
     * 收集
     * collect——将流转换为其他形式。接收一个 Collector 接口的实现，用于给 Stream 中元素做汇总的方法
     */
    @Test
    public void test2(){
        List<String> list = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println("----------------------------------");

        Set<String> set = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);

        System.out.println("----------------------------------");

        //注意：toCollection() 传入的是一个接口的实现类
        HashSet<String> hs = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        hs.forEach(System.out::println);

    }

    @Test
    public void test3(){
        Long count = employees.stream()
                .collect(Collectors.counting());
        System.out.println(count);

        System.out.println("----------------------------------");

        Double avg = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);

        System.out.println("----------------------------------");

        Double sum = employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);

        System.out.println("----------------------------------");

        Optional<Employee> max = employees.stream()
                .collect(Collectors.maxBy((e1,e2) -> Double.compare(e1.getSalary(),e2.getSalary())));

        System.out.println(max.get());

        System.out.println("----------------------------------");

        Optional<Double> min = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.out.println(min.get());

    }

    //分组
    @Test
    public void test4(){
        Map<Employee.Status,List<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
    }

    //多级分组
    @Test
    public void test5(){
        Map<Employee.Status,Map<String,List<Employee>>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus,Collectors.groupingBy((e) -> {
                    if(((Employee) e).getAge() <= 35){
                        return "青年";
                    }else if(((Employee) e).getAge() <= 50){
                        return "中年";
                    }else{
                        return "老年";
                    }
                })));
        System.out.println(map);
    }

    //分区
    @Test
    public void test6(){
        Map<Boolean,List<Employee>> map = employees.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() >= 5000));
        System.out.println(map);
    }

    @Test
    public void test7(){
        DoubleSummaryStatistics dss = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getSum());
        System.out.println(dss.getAverage());
        System.out.println(dss.getMax());
    }
    
    @Test
    public void test8(){
        String collect = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",", "{", "}"));
        System.out.println(collect);

    }
}