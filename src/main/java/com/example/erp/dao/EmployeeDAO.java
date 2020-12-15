package com.example.erp.dao;

import com.example.erp.bean.Employee;

public interface EmployeeDAO {
    public abstract void addEmployee(Employee emp);
    public abstract boolean login(String email);
}
