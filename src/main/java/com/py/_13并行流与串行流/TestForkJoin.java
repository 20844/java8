package com.py._13并行流与串行流;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class TestForkJoin {

    /**
     * ForkJoin框架    计算量小 for效率高   计算量越大forkjoin效率越明显 更能充分利用多核cpu资源
     */
    @Test
    public void test(){
        Instant start = Instant.now();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalc(1,10000000000L);
        Long invoke = forkJoinPool.invoke(task);
        System.out.println(invoke);

        Instant end = Instant.now();

        System.out.println("耗费时间为："+ Duration.between(start,end).toMillis());


    }


    /**
     * 普通for循环  计算量小 for效率高   计算量越大forkjoin效率越明显 更能充分利用多核cpu资源
     */
    @Test
    public void test1(){
        Instant start = Instant.now();

        long sum = 0;
        for (long i = 0; i <= 10000000000L; i++) {
            sum+=i;
        }
        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println("耗费时间为："+ Duration.between(start,end).toMillis());


    }


    /**
     * java8 并行流
     */
    @Test
    public void test2(){
        Instant start = Instant.now();
        long reduce = LongStream.rangeClosed(0, 10000000000L)
                .parallel()
                .reduce(0, Long::sum);

        System.out.println(reduce);

        Instant end = Instant.now();
        System.out.println("耗费时间为："+ Duration.between(start,end).toMillis());
    }
}
