package com.py._01为什么使用Lamda表达式;

public class FilterEmployeeByAge implements MyPredicate<Employee>{
    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }
}
