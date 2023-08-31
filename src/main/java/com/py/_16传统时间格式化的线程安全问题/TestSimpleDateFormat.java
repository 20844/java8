package com.py._16传统时间格式化的线程安全问题;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.*;

public class TestSimpleDateFormat  {
    @Test
    public void test01(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Callable<Date> task = () -> sdf.parse("20230831");

        ExecutorService pool = Executors.newFixedThreadPool(10);

        ArrayList<Future<Date>> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(pool.submit(task));
        }

        for (Future<Date> future : result) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        pool.shutdown();
    }
}
