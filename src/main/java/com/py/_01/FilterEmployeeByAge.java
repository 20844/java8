package com.py._01;

public class FilterEmployeeByAge implements MyPredicate<Employee>{
    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }
}
