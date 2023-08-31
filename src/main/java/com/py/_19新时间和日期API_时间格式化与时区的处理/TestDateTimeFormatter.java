package com.py._19新时间和日期API_时间格式化与时区的处理;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;

public class TestDateTimeFormatter {

    /**
     * DateTimeFormatter：格式化时间 / 日期
     */
    @Test
    public void test01(){
        //默认格式化
        DateTimeFormatter dtf1 = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime ldt1 = LocalDateTime.now();
        String str1 = ldt1.format(dtf1);
        System.out.println(str1);

        //自定义格式化 ofPattern
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String str2 = ldt1.format(dtf2);
        String str3 = dtf2.format(ldt1);
        System.out.println(str2);
        System.out.println(str3);


        //解析
        LocalDateTime newDate = ldt1.parse(str1, dtf1);
        System.out.println(newDate);
    }


    /**
     * 时区
     * ZonedDate
     * ZonedTime
     * ZonedDateTime
     */
    @Test
    public void test02(){
        //查看支持的时区
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);

        //指定时区
        LocalDateTime ldt1 = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(ldt1);

        //在已构建好的日期时间上指定时区
        LocalDateTime ldt2 = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
        ZonedDateTime zdt1 = ldt2.atZone(ZoneId.of("Europe/Tallinn"));
        System.out.println(zdt1);
    }

    @Test
    public void test03(){
        // Date 转 LocalDateTime
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();

        // LocalDateTime 转 Date
        LocalDateTime localDateTime1 = LocalDateTime.now();
        ZoneId zoneId1 = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date1 = Date.from(zdt.toInstant());

        // 原则：利用 时间戳Instant
    }
}
