package com.example.erp.service;

import com.example.erp.bean.Employee;
import com.example.erp.dao.EmployeeDAO;
import com.example.erp.dao.impl.EmployeeDAOImpl;

public class EmployeeService {

    public boolean verifyEmail(String email){
        return new EmployeeDAOImpl().emailVerify(email);
    }
}
