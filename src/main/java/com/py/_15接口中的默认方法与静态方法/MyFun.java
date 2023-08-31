package com.py._15接口中的默认方法与静态方法;

public interface MyFun {
    default String getName(){
        return "py";
    }

    default Integer getAge(){
        return 22;
    }

    static void getAddr(){
        System.out.println("addr");
    }

    static String Hello(){
        return "Hello World";
    }
}
