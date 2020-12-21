package com.example.erp.dao.impl;

import com.example.erp.bean.Department;
import com.example.erp.bean.Employee;
import com.example.erp.dao.DepartmentDAO;
import com.example.erp.utils.SessionUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {

    @Override
    public void addDepartment(Department dept) {
        // Get the session
        try(Session session = SessionUtils.getSession())
        {
            // Begin transaction
            session.beginTransaction();
            Integer id  = (Integer)session.save(dept);
            System.out.println("Department created with id:"+id);

            session.getTransaction().commit();
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateDepartment(Department department) {
        try(Session session = SessionUtils.getSession())
        {
            // Begin transaction
            session.beginTransaction();
            session.update(department);
            System.out.println("Updated Successfully!");
            session.getTransaction().commit();
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getDepartment() {
        Session session = SessionUtils.getSession();
        try {
            Query query = session.createQuery("from Department");

            List<Department> dept = query.list();
            List<String> department = new ArrayList<>();

            for(Department d: dept){
                department.add(d.getDname());
            }

            return department;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public List<Department> readDepartment(){
        Session session = SessionUtils.getSession();
        try {
            Query query = session.createQuery("from Department");

            List<Department> dept = query.list();
            return dept;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public List<Employee> getEmployeesByDeptId(int id) {
        Session session = SessionUtils.getSession();
        try {
            Department department=new Department();
            department.setDept_id(id);
            Query query = session.createQuery("from Employee emp where emp.dept_id= :department");
            query.setParameter("department", department);
            List<Employee> employees = query.list();
            return employees;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteDepartment(int id) {
        try(Session session = SessionUtils.getSession())
        {
            // Begin transaction
            Query query = session.createQuery("from Department where dept_id=:did");
            query.setParameter("did",id);

            Department d = (Department) query.uniqueResult();

            session.beginTransaction();
            session.delete(d);
            System.out.println("Deleted Successfully!");
            session.getTransaction().commit();
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
    }


}
