package com.example.erp.dao;

import com.example.erp.bean.Department;
import com.example.erp.bean.Employee;

import java.util.List;

public interface DepartmentDAO {
    public abstract void addDepartment(Department dept);
    public abstract void updateDepartment(Department department);
    public abstract List<String> getDepartment();
    public abstract List<Department> readDepartment();
    public abstract  List<Employee> getEmployeesByDeptId(int id);
}
