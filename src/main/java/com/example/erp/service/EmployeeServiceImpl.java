package com.example.erp.service;

import com.example.erp.bean.Employee;
import com.example.erp.dao.impl.EmployeeDAOImpl;
import com.example.erp.utils.SessionUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class EmployeeServiceImpl implements  EmployeeService{
    @Override
    public void addEmployee(Employee employee) {
        new EmployeeDAOImpl().addEmployee(employee);
    }

    @Override
    public boolean verifyEmail(String email) {
        Session session = SessionUtils.getSession();
        try {
            Query query = session.createQuery("from Employee where email=:email");
            query.setParameter("email", email);
            if(query.getResultList().size()==1){
                System.out.println(email);
                return true;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }finally {
            session.close();
        }
        return false;
    }
}
