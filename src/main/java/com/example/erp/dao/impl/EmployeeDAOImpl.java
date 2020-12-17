package com.example.erp.dao.impl;

import com.example.erp.bean.Employee;
import com.example.erp.dao.EmployeeDAO;
import com.example.erp.utils.SessionUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public void addEmployee(Employee employee) {
        // Get the session
        try(Session session = SessionUtils.getSession())
        {
            // Begin transaction
            session.beginTransaction();
            Integer id  = (Integer)session.save(employee);
            System.out.println("Employee added with id:"+id);

            session.getTransaction().commit();
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
    }






}
