package com.tpanda.dao;

import com.tpanda.entity.Student;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class StudentDao implements personDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean login(String name, String pwd) {
        Session session = sessionFactory.getCurrentSession();
        String stuPwd = (String) session.createQuery("select stuPwd from Student where stuId = :sid").setParameter("sid",Integer.parseInt(name)).uniqueResult();
        if (pwd.equals(stuPwd)){
            return true;
        }
        return false;
    }

}
