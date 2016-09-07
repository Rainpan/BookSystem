package com.tpanda.dao;

import com.tpanda.entity.table.Student;
import com.tpanda.entity.view.VStudent;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //登录
    public Student login(int id, String pwd) {
        Student student = (Student) sessionFactory.getCurrentSession().createQuery("from Student where stuId = :sid").setParameter("sid",id).uniqueResult();
        if (pwd.equals(student.getStuPwd())){return student;}
        return null;
    }

    //获取学生信息
    public VStudent getInfor(int id){
        return  (VStudent) sessionFactory.getCurrentSession().createQuery("from VStudent where 学号=?").setInteger(0,id).uniqueResult();
    }

}
