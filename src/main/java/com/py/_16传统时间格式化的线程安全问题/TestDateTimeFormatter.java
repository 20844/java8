package com.py._16传统时间格式化的线程安全问题;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.*;

public class TestDateTimeFormatter {
    @Test
    public void test03(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");

        Callable<LocalDate> task = () -> LocalDate.parse("20200517",dtf);

        ExecutorService pool = Executors.newFixedThreadPool(10);

        ArrayList<Future<LocalDate>> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(pool.submit(task));
        }

        for (Future<LocalDate> future : result) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        pool.shutdown();
    }
}
