package com.tpanda.service;

import com.tpanda.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Transactional(readOnly = true)
    public boolean login(int id,String pwd){
        return studentDao.login(id,pwd);
    }
}
