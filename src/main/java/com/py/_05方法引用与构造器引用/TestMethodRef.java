package com.py._05方法引用与构造器引用;

import com.py._01为什么使用Lamda表达式.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/*
    * 一、方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用“方法引用”
    *          （可以理解为方法引用是Lambda表达式的另外一种表现形式）
    *
    * 主要有三种语法格式：
    *
    * 对象::实例方法名
    *
    * 类::静态方法名
    *
    * 类::实例方法名
    *
    * 注意：
    * ①lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致！
    * ②若Lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method   eg:test4()
    *
    * 二、构造器引用
    * 格式：
    * ClassName::new
    *
    *
    * 三、数组引用
    *
    * Type::new
    *
 */
public class TestMethodRef {

    //对象::实例方法名
    @Test
    public void test1(){
        PrintStream ps1 = System.out;
        Consumer<String> con = (x) -> ps1.println(x);

        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;

        Consumer<String> con2 = System.out::println;
        con2.accept("abcdef");
    }

    @Test
    public void test2(){
        Employee emp = new Employee();
        Supplier<String> sup = () -> emp.getName();
        String s = sup.get();
        System.out.println(s);

        Supplier<Integer> sup2 = emp::getAge;
        Integer i = sup2.get();
        System.out.println(i);

    }



    //类::静态方法名
    @Test
    public void test3(){
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);

        Comparator<Integer> com1 = Integer::compare;
        System.out.println(com1.compare(1, 2));
    }

    //类::实例方法名
    //若Lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method
    @Test
    public void test4(){
        BiPredicate<String,String> bp = (x, y) -> x.equals(y);

        BiPredicate<String,String> bp2 = String::equals;
        System.out.println(bp2.test("abc", "abc"));
    }

    //构造器引用
    @Test
    public void test5(){
        Supplier<Employee> sup = () -> new Employee();

        //构造器引用方式
        Supplier<Employee> sup2 = Employee::new;//lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致！
        Employee employee = sup2.get();
        System.out.println(employee);

    }

    @Test
    public void test6(){
        Function<Integer,Employee> fun = (x) -> new Employee(x);

        Function<Integer,Employee> fun2 = Employee::new;
        Employee employee = fun2.apply(101);
        System.out.println(employee);

        BiFunction<Integer,Double,Employee> bf = Employee::new;
        Employee employee2 = bf.apply(102, 8888.88);
        System.out.println(employee2);
    }

    //数组引用
    @Test
    public void test7(){
        Function<Integer,String[]> fun = (x) -> new String[x];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);

        Function<Integer,String[]> fun2 = String[]::new;
        String[] strs2 = fun2.apply(20);
        System.out.println(strs2.length);
    }

}
