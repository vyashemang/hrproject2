package com.example.erp.service;

import com.example.erp.dao.EmployeeDAO;
import com.example.erp.dao.impl.EmployeeDAOImpl;

public class EmployeeService {
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    public boolean verifyEmail(String email){
        return employeeDAO.emailVerify(email);
    }
}
