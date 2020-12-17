package com.example.erp.service;

import com.example.erp.bean.Department;
import com.example.erp.dao.impl.DepartmentDAOImpl;

public class DepartmentServiceImpl implements DepartmentService{

    @Override
    public void addDepartment(Department department) {
        new DepartmentDAOImpl().addDepartment(department);
    }
}
