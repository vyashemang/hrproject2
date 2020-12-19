package com.example.erp.service;

import com.example.erp.bean.Employee;
import com.example.erp.dao.EmployeeDAO;
import com.example.erp.dao.impl.EmployeeDAOImpl;

public interface EmployeeService {
    public abstract  void addEmployee(Employee employee);
    public abstract boolean verifyEmail(String email);
}
