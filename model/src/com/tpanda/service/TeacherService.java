package com.tpanda.service;


import com.tpanda.dao.TeacherDao;
import com.tpanda.entity.table.Teacher;
import com.tpanda.entity.view.VTcQueryCourse;
import com.tpanda.entity.view.VTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public VTeacher getInfor(int tcId){
        return teacherDao.getInfor(tcId);
    }

    @Transactional
    public List<VTcQueryCourse> getCourseOfStu(int id){
        return teacherDao.getCourseOfStu(id);
    }
}
