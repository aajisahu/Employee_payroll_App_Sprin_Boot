package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeePayrollData {
    @Id
    @Column(name = "employeeId")
    private int employeeId;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private long salary;
    public EmployeePayrollData(int employeeId, String name, long salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    public EmployeePayrollData(int employeeId, EmployeePayrollDTO empPayrollDTO) {

    }

    public EmployeePayrollData() {

    }


    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getSalary() {
        return salary;
    }
    public void setSalary(long salary) {
        this.salary = salary;
    }
}