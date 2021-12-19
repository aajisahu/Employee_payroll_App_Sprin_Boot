package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
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
    public EmployeePayrollData() {}
    public EmployeePayrollData(int employeeId, EmployeePayrollDTO empPayrollDTO) {}

}