package com.tpanda.service;


import com.tpanda.dao.ClassDao;
import com.tpanda.entity.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassService {

    @Autowired
    private ClassDao classDao;

    public void setClassDao(ClassDao classDao) {
        this.classDao = classDao;
    }

    @Transactional(readOnly = true)
    public List<Class> selectClass(){
        return classDao.selectClass();
    }
}
