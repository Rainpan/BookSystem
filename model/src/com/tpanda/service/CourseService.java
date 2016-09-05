package com.tpanda.service;


import com.tpanda.dao.CourseDao;
import com.tpanda.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseDao classDao;

    public void setClassDao(CourseDao classDao) {
        this.classDao = classDao;
    }

    @Transactional(readOnly = true)
    public List<Course> selectClass(){
        return classDao.selectClass();
    }

    @Transactional(readOnly = true)
    public List studentToClass(int id){
        return classDao.studentToClass(id);
    }
}
