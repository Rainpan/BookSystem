package com.tpanda.service;


import com.tpanda.dao.TeacherDao;
import com.tpanda.entity.table.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Transactional(readOnly = true)
    public Teacher login(int tcId,String pwd){
        return teacherDao.login(tcId,pwd);
    }

    @Transactional
    public Teacher infor(int tcId){
        return teacherDao.infor(tcId);
    }
}
