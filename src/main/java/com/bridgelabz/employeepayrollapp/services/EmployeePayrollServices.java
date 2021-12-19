package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class EmployeePayrollServices implements IEmployeePayrollService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {

        return employeeRepository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeeRepository.findById(empId)
                .orElseThrow(() -> new EmployeePayrollException("Employee with EmployeeId" + empId
                        + " Doesn't Exists...!"));

    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(empPayrollDTO);
        log.debug("Employee Data: " + empData.toString());
        return employeeRepository.save(empData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.updateEmployeePayollData(empPayrollDTO);
        return employeeRepository.save(empData);
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        employeeRepository.delete(empData);

    }
}