package com.tpanda.service;


import com.tpanda.dao.CourseDao;
import com.tpanda.entity.view.VStuQueryCourseEntity;
import com.tpanda.entity.view.VStuSelectCourseEntity;
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
    public List<VStuSelectCourseEntity> studentToClass(int id){
        return classDao.studentToClass(id);
    }

    @Transactional(readOnly = true)
    public List<VStuQueryCourseEntity> studentCourse(int id){
        return classDao.studentCourse(id);
    }

    @Transactional(readOnly = false)
    public void addCourse(int stuId,String[] course,String[] tcsId){
        classDao.addCourse(stuId,course,tcsId);
    }

    @Transactional(readOnly = false)
    public void deleteCourse(int stuId,String[] course){
        classDao.deleteCourse(stuId,course);
    }
}
