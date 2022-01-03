package com.bridgelabz.employeepayrollapp.dto;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import lombok.Data;

import java.util.List;

public @Data
class ResponseDTO {
    private String message;
    private List<EmployeePayrollData> employeePayrollDataList;
    private Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public ResponseDTO(String message, List<EmployeePayrollData> employeePayrollDataList) {
        this.message = message;
        this.employeePayrollDataList=employeePayrollDataList;
    }

}