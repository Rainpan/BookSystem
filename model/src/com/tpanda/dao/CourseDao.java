package com.tpanda.dao;

import com.tpanda.entity.VStuSelectCourseEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tpanda.entity.Course;

import java.util.List;

@Repository
public class CourseDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //返回全部课程
    @SuppressWarnings("unchecked")
    public List<Course> selectClass(){
        return sessionFactory.getCurrentSession().createCriteria(Course.class).list();
    }

    //根据学生的学号返回能选的课程
    @SuppressWarnings("unchecked")
    public List<VStuSelectCourseEntity> studentToClass(int id){
        Session session = sessionFactory.getCurrentSession();
        List<VStuSelectCourseEntity> list = session.createQuery("from VStuSelectCourseEntity WHERE 学号=?").setInteger(0,id).list();
        return list;
    }

    //根据学生的学号返回已选的课程
    @SuppressWarnings("unchecked")
    public List<Course> studentClass(int id){
        return sessionFactory.getCurrentSession().createCriteria(Course.class).list();
    }

}
