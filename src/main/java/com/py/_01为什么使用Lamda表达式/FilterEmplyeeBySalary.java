package com.py._01为什么使用Lamda表达式;

public class FilterEmplyeeBySalary implements MyPredicate<Employee>{
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary()>=5000;
    }
}
