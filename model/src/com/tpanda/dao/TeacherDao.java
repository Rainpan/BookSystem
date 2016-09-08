package com.tpanda.dao;

import com.tpanda.entity.table.Teacher;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public Teacher infor(int tcId){
        return (Teacher) sessionFactory.getCurrentSession().createQuery("from VTeacher where 教工编号=?").setInteger(0,tcId).uniqueResult();
    }

    //上传学生信息
    public void uplocadStudentInfor(){

    }
}
