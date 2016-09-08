package com.tpanda.dao;

import com.tpanda.entity.view.VStuQueryCourseEntity;
import com.tpanda.entity.view.VStuSelectCourseEntity;
import com.tpanda.entity.table.course_student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
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
    public List<VStuQueryCourseEntity> studentCourse(int id){
        Session session = sessionFactory.getCurrentSession();
        List<VStuQueryCourseEntity> list = session.createQuery("from VStuQueryCourseEntity where 学号=?").setInteger(0,id).list();
        return list;
    }

    //增加选择的课程
    public void addCourse(int stuId,String[] course,String[] tcsId){
        Session session = sessionFactory.getCurrentSession();
        for (int i=0;i<course.length;i++){
            course_student cs = new course_student();
            cs.setClaId(Integer.parseInt(course[i]));
            cs.setTcId(Integer.parseInt(tcsId[i]));
            cs.setStuId(stuId);
            session.save(cs);
            session.flush();
        }
    }

    //退选课程
    public void deleteCourse(int stuId,String[] course){
        Session session = sessionFactory.getCurrentSession();
        for(String cou:course){
            Query query = session.createQuery("delete from course_student where stuId=? and claId=?");
            query.setInteger(0,stuId);
            query.setInteger(1,Integer.parseInt(cou));
            query.executeUpdate();
        }
    }

}
