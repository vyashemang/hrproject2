package com.example.erp.dao.impl;

import com.example.erp.bean.Department;
import com.example.erp.bean.Employee;
import com.example.erp.dao.EmployeeDAO;
import com.example.erp.utils.SessionUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
    public boolean emailVerify(String email) {
        Session session = SessionUtils.getSession();
        try {
            Query emp_query = session.createQuery("from Employee where email=:email");
            emp_query.setParameter("email", email);

            Employee e = (Employee) emp_query.uniqueResult();
            Department d = e.getDept_id();

            // Comapre the dept_id as well.
            if(emp_query.getResultList().size()==1 && d.getDept_id() == 1){
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
