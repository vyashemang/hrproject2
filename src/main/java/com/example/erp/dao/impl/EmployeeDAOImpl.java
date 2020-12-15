package com.example.erp.dao.impl;

import com.example.erp.bean.Employee;
import com.example.erp.dao.EmployeeDAO;
import com.example.erp.utils.SessionUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public void addEmployee(Employee emp) {
        // Get the session
        try(Session session = SessionUtils.getSession())
        {
            // Begin transaction
            session.beginTransaction();
            Integer id  = (Integer)session.save(emp);
            System.out.println("Employee added with id:"+id);

            session.getTransaction().commit();
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean login(String email) {
        // Get the session
        boolean valid = false;
        try(Session session = SessionUtils.getSession())
        {
            // Begin transaction
            session.beginTransaction();
            //Integer id  = (Integer)session.save(emp);
            //System.out.println("Employee added with id:"+id);

            // If valid
            valid = true;

            session.getTransaction().commit();
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
        return valid;
    }


}
