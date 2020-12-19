package com.example.erp.dao;

import com.example.erp.bean.Department;

import java.util.List;

public interface DepartmentDAO {
    public abstract void addDepartment(Department dept);
    public abstract List<String> getDepartment();
    public abstract List<Department> readDepartment();
}
