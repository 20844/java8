package com.py._03Lamada练习;

import com.py._01为什么使用Lamda表达式.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestLamada3 {
    /**
     * 1.调用 Collections.sort()方法，通过定制排序比较两个 Employee (先按年龄比，年龄相同按姓名比)，使用 Lambda 作为参数传递
     *
     * 2.①声明函数式接口，接口中声明抽象方法，public String getValue(String str);
     *   ②声明类 TestLambda，类中编写方法使用接口作为参数，将一个字符串转换成大写，并作为方法的返回值。
     *   ③再将一个字符串的第2个和第4个索引位置进行截取子串。
     *
     * 3.①声明一个带两个泛型的函数式接口，泛型类型为<T,R> T为参数，R为返回值
     *   ②接口中声明对应抽象方法
     *   ③在 TestLambda 类中声明方法，使用接口作为参数，计算两个 long 型参数的和。
     *   ④再计算两个 long 型参数的乘积。
     */

    List<Employee> employees = Arrays.asList(
            new Employee("张三",18,9999.99),
            new Employee("李四",38,5555.99),
            new Employee("王五",50,6666.66),
            new Employee("赵六",16,3333.33),
            new Employee("田七",8,7777.77)
    );
    @Test
    public void test1() {
        Collections.sort(employees,(e1,e2) -> {
            if(e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else{
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void test2() {
        String trimStr = strHandler("\t\t\t 我大尚硅谷威武   ",(str) -> str.trim());
        System.out.println(trimStr);

        String upper = strHandler("abcdef",(str) -> str.toUpperCase());
        System.out.println(upper);

        String newStr = strHandler("我大尚硅谷威武",(str) -> str.substring(2,5));
        System.out.println(newStr);
    }
    public String strHandler(String str,MyFunction mf){
        return mf.getValue(str);
    }
    
    @Test
    public void test3() {
        op(100L,200L,(x,y) -> x + y);

        op(100L,200L,(x,y) -> x * y);
    }
    public void op(Long l1,Long l2,MyFunction2<Long,Long> mf){
        System.out.println(mf.getValue(l1,l2));
    }


}
