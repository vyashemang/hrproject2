package com.example.erp.service;

import com.example.erp.dao.impl.EmployeeDAOImpl;

public class EmployeeService {
    public boolean login(String email){
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

        if(employeeDAO.login(email)){
            return true;
        }

        return false;
    }
}
