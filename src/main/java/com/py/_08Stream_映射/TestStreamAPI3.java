package com.py._08Stream_映射;

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
public class TestStreamAPI3 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.99),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77),
            new Employee("田七", 8, 7777.77),
            new Employee("田七", 8, 7777.77)
    );


    //中间操作
    /**
     * 映射
     * map-接收Lambda,将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     * flatMap-接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     */

    @Test
    public void test1(){
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
        list.stream()
                .map((str) -> str.toUpperCase())
                .forEach(System.out::println);

        System.out.println("----------------------------------");

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("----------------------------------");

        //map(Function<? super T, ? extends R> mapper)——接收一个函数作为参数，该函数会被应用到每个元素上，
        // 并将其映射成一个新的元素。
        //flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)——接收一个函数作为参数，
        // 将流中的每个值都换成另一个流，然后把所有流连接成一个流
        list.stream()
                .flatMap(TestStreamAPI3::filterCharacter)
                .forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    //map flatMap 类似于 add addAll
    @Test
    public void test2(){
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");

        List list2 = new ArrayList<>();
        list2.add(11);
        list2.add(22);
        list2.add(list);

        List list3 = new ArrayList<>();
        list3.add(11);
        list3.add(22);
        list3.addAll(list);

        System.out.println(list2);
        System.out.println(list3);

    }



}