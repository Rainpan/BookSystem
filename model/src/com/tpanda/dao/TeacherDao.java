package com.tpanda.dao;

import com.tpanda.entity.table.Teacher;
import com.tpanda.entity.view.VTcQueryCourse;
import com.tpanda.entity.view.VTeacher;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //登录
    public Teacher login(int tcId,String pwd){
        Teacher teacher =  (Teacher) sessionFactory.getCurrentSession().createCriteria(Teacher.class).add(Restrictions.eq("tcId",tcId)).uniqueResult();
        if (teacher!=null && pwd.equals(teacher.getTcPwd())){
            return teacher;
        }else return null;
    }

    //获取个人信息
    public VTeacher getInfor(int tcId){
        return (VTeacher) sessionFactory.getCurrentSession().createQuery("from VTeacher where 教工编号=?").setInteger(0,tcId).uniqueResult();
    }

    //查询课程的学生
    @SuppressWarnings("unchecked")
    public List<VTcQueryCourse> getCourseOfStu(int id){
        List<VTcQueryCourse> list = sessionFactory.getCurrentSession().createQuery("from VTcQueryCourse where 老师编号=?").setInteger(0,id).list();
        return list;
    }

    //上传学生信息
    public void uplocadStudentInfor(){

    }
}
