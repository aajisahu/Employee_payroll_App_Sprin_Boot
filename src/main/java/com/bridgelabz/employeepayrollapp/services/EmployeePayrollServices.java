package com.bridgelabz.employeepayrollapp.services;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollServices implements IEmployeePayrollService{
    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollList.get(empId-1);
    }
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData= new EmployeePayrollData();
        employeePayrollData.setEmployeeId(empPayrollDTO.getEmployeeId());
        employeePayrollData.setName(empPayrollDTO.getName());
        employeePayrollData.setSalary(empPayrollDTO.getSalary());
        employeePayrollList.add(employeePayrollData);
        return employeePayrollData;
    }
    /**
     * we are using arrayList so according to the index value given by the user update operation will be perform
     *
     */
    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        {
                empData.setName(empPayrollDTO.name);
                empData.setSalary(empPayrollDTO.salary);
                employeePayrollList.set(empId - 1, empData);
                return empData;
        }
    }
    @Override
    public void deleteEmployeePayrollData(int empId)
    {
        employeePayrollList.remove(empId-1);

    }
}