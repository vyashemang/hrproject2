package com.example.erp.service;

import com.example.erp.bean.Department;
import com.example.erp.bean.Employee;
import com.example.erp.dao.impl.DepartmentDAOImpl;

import java.util.List;

public class DepartmentService {
    public void addDepartment(Department dept) {

        new DepartmentDAOImpl().addDepartment(dept);
    }

    public List<String> getDepartment(){

        return new DepartmentDAOImpl().getDepartment();
    }

    public List<Department> readDepartment(){

        return new DepartmentDAOImpl().readDepartment();
    }

    public List<Employee> getEmployeesByDeptId(int id){
        return new DepartmentDAOImpl().getEmployeesByDeptId(id);
    }

    public void updateDepartment(Department department){
        new DepartmentDAOImpl().updateDepartment(department);
    }
}
