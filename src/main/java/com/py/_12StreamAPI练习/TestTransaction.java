package com.py._12StreamAPI练习;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestTransaction {
    List<Transaction> transactions = null;

    @Before
    public void before(){
        Trader zhangsan = new Trader("zhangsan","beijing");
        Trader lisi = new Trader("lisi","beijing");
        Trader wangwu = new Trader("wangwu","guangzhou");
        Trader zhaoliu = new Trader("zhaoliu","shenzhen");

        transactions = Arrays.asList(
                new Transaction(zhaoliu,2011,300),
                new Transaction(zhangsan,2012,1000),
                new Transaction(zhangsan,2011,400),
                new Transaction(lisi,2012,700),
                new Transaction(lisi,2012,300),
                new Transaction(wangwu,2012,950)
        );
    }
    // 1.找出2011年发生的所有交易，并按交易额排序（从低到高）。
    @Test
    public void test1(){
        transactions.stream()
                .filter(e->e.getYear()==2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(System.out::println);
        transactions.stream()
                .filter(e->e.getYear()==2011)
                .sorted((t1,t2)->t1.getValue().compareTo(t2.getValue()))
                .forEach(System.out::println);
    }


    // 2.交易员都在哪些不同的城市工作过？
    @Test
    public void test2(){
        transactions.stream()
                .map(e->e.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
    // 3.查找所有来自于beijing的交易员，并按姓名排序。
    @Test
    public void test3(){
        transactions.stream()
                .filter(e->e.getTrader().getCity().equals("beijing"))
                .map(e->e.getTrader())
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .forEach(System.out::println);
        System.out.println("------------------------------");
        transactions.stream()
                .filter(e->e.getTrader().getCity().equals("beijing"))
                .map(e->e.getTrader())
                .sorted((t1,t2)->t1.getName().compareTo(t2.getName()))
                .distinct()
                .forEach(System.out::println);
    }
    // 4.返回所有交易员的姓名字符串，按字母顺序排序。
    @Test
    public void test4(){
        transactions.stream()
                .map(e->e.getTrader().getName())
                .sorted((t1,t2)->t1.compareTo(t2))
                .distinct()
                .forEach(System.out::println);
        System.out.println("------------------------------");
        transactions.stream()
                .map(e->e.getTrader().getName())
                .sorted(String::compareTo)
                .distinct()
                .forEach(System.out::println);
    }
    // 5.有没有交易员是在beijing工作的？
    @Test
    public void test5(){
        boolean beijing = transactions.stream()
                .anyMatch(e -> e.getTrader().getCity().equals("beijing"));
        System.out.println(beijing);

    }
    // 6.打印生活在beijing的交易员的所有交易额。
    @Test
    public void test6(){
        Optional<Integer> beijing = transactions.stream()
                .filter(e -> e.getTrader().getCity().equals("beijing"))
                .map(e -> e.getValue())
                .reduce(Integer::sum);
        System.out.println(beijing.get());

    }
    // 7.所有交易中，最高的交易额是多少？
    @Test
    public void test7(){
        Optional<Integer> max = transactions.stream()
                .map(e -> e.getValue())
                .max(Integer::compareTo);
        System.out.println(max.get());



    }
    // 8.找到交易额最小的交易。
    @Test
    public void test8(){
        Optional<Transaction> min = transactions.stream()
                .min((t1, t2) -> t1.getValue().compareTo(t2.getValue()));
        System.out.println(min.get());

    }

}
