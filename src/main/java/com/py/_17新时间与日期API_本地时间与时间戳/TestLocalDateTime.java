package com.py._17新时间与日期API_本地时间与时间戳;

import org.junit.Test;

import java.time.*;

public class TestLocalDateTime {
    @Test
    public void test01(){
        //获取当前时间日期 now
        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println(ldt1);

        //指定时间日期 of
        LocalDateTime ldt2 = LocalDateTime.of(2020, 05, 17, 16, 24, 33);
        System.out.println(ldt2);

        //加 plus
        LocalDateTime ldt3 = ldt2.plusYears(2);
        System.out.println(ldt3);

        //减 minus
        LocalDateTime ldt4 = ldt2.minusMonths(3);
        System.out.println(ldt4);

        //获取指定的你年月日时分秒... get
        System.out.println(ldt2.getDayOfYear());
        System.out.println(ldt2.getHour());
        System.out.println(ldt2.getSecond());
    }


    /**
     * 时间戳
     * Instant：以 Unix 元年 1970-01-01 00:00:00 到某个时间之间的毫秒值
     */
    @Test
    public void test02(){
        // 默认获取 UTC 时区 (UTC：世界协调时间)
        Instant ins1 = Instant.now();
        System.out.println(ins1);

        //带偏移量的时间日期 (如：UTC + 8)
        OffsetDateTime odt1 = ins1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt1);

        //转换成对应的毫秒值
        long milli1 = ins1.toEpochMilli();
        System.out.println(milli1);

        //构建时间戳
        Instant ins2 = Instant.ofEpochSecond(60);
        System.out.println(ins2);


    }


    /**
     * 时间 / 日期 差
     * Duration：计算两个时间之间的间隔
     * Period：计算两个日期之间的间隔
     */
    @Test
    public void test03(){
        //计算两个时间之间的间隔 between
        Instant ins1 = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant ins2 = Instant.now();
        Duration dura1 = Duration.between(ins1, ins2);
        System.out.println(dura1.getSeconds());
        System.out.println(dura1.toMillis());
        System.out.println("耗费时间为："+ Duration.between(ins1,ins2).toMillis());
    }


    /**
     * 时间 / 日期 差
     * Duration：计算两个时间之间的间隔
     * Period：计算两个日期之间的间隔
     */
    @Test
    public void test04(){
        LocalDate ld1 = LocalDate.of(2016, 9, 1);
        LocalDate ld2 = LocalDate.now();
        Period period = Period.between(ld1, ld2);  // ISO 标准
        System.out.println(period.getYears());
        System.out.println(period.toTotalMonths());
    }


    @Test
    public void test5(){
        Instant start = Instant.now();

        long sum = 0;
        for (long i = 0; i <= 100000L; i++) {
            sum+=i;
        }
        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println("耗费时间为："+ Duration.between(start,end).toMillis());


    }
}
