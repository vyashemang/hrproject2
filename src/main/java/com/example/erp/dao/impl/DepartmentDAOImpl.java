package com.example.erp.dao.impl;

import com.example.erp.bean.Department;
import com.example.erp.dao.DepartmentDAO;
import com.example.erp.utils.SessionUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

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
}
