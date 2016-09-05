package com.tpanda.dao;

import com.tpanda.entity.Class;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class StudentDao {

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
