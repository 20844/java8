package com.py._16传统时间格式化的线程安全问题;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.*;

/**
 * 加锁：
 */
public class TestDateFormatThreadLocal {
    private static final ThreadLocal<DateFormat> df = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static Date convert(String source) throws ParseException {
        return df.get().parse(source);
    }

    @Test
    public void test02() {
        Callable<Date> task = () -> TestDateFormatThreadLocal.convert("2023-08-31");

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
