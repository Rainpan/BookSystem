package com.tpanda.dao;

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
/*        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("{Call ms()}");
        List<Class> list = query.list();
        for (Class c:list){
            System.out.println(c.getClaName()+";"+c.getClaId());
        }*/
        return sessionFactory.getCurrentSession().createCriteria(Course.class).list();
    }

    //根据学生的学号返回能选的课程
    public List<Course> studentToClass(int id){

        System.out.println("studentToClass初始化");
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select cla.claId,cla.claName,cla.claCredit,tc.tcName from Student stu,Profession pro,Teacher tc,course_teacher ct,Course cla " +
                "where stu.proId=pro.proId and pro.proId=tc.proId and tc.tcId=ct.tcId and cla.claId=ct.claId and stu.stuId=3001");
        List list = query.list();
        Object[] objects = list.toArray();
        for (Object o:objects){
            System.out.println(o);
        }
        System.out.println("studentToClass结束");
        return sessionFactory.getCurrentSession().createCriteria(Course.class).list();
    }

    //根据学生的学号返回已选的课程
    public List<Course> studentClass(int id){

        return sessionFactory.getCurrentSession().createCriteria(Course.class).list();
    }

}
