package com.py._01;

public class FilterEmplyeeBySalary implements MyPredicate<Employee>{
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary()>=5000;
    }
}
