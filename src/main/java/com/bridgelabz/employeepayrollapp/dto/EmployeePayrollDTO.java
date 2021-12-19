package com.bridgelabz.employeepayrollapp.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class EmployeePayrollDTO {

    @NotEmpty(message = "Employee Name can't be null")
    public String name;

    @Min(value = 500, message = "Min Wage should be more than 500")
    public long salary;

    public EmployeePayrollDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Name=" + name + " Salary=" + salary;
    }
}