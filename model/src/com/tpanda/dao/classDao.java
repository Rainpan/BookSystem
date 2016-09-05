package com.tpanda.dao;

import com.tpanda.entity.Class;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //返回全部课程
    @SuppressWarnings("unchecked")
    public List<Class> selectClass(){

        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("{Call ms()}");
        List<Class> list = query.list();
        for (Class c:list){
            System.out.println(c.getClaName()+";"+c.getClaId());
        }

        return sessionFactory.getCurrentSession().createCriteria(Class.class).list();
    }

    //根据学生的学号返回能选的课程
    public List<Class> studentToClass(int id){
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("from Student stu,Profession pro,Teacher tc");
        return sessionFactory.getCurrentSession().createCriteria(Class.class).list();
    }

    //根据学生的学号返回已选的课程
    public List<Class> studentClass(int id){

        return sessionFactory.getCurrentSession().createCriteria(Class.class).list();
    }
}
