package com.example.erp.service;

import com.example.erp.bean.Department;
import com.example.erp.dao.impl.DepartmentDAOImpl;

public class DepartmentService {
    public void addDepartment(Department dept) {
        new DepartmentDAOImpl().addDepartment(dept);
    }
}
