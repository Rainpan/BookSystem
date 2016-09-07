package com.tpanda.service;

import com.tpanda.dao.StudentDao;
import com.tpanda.entity.table.Student;
import com.tpanda.entity.view.VStudent;
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

    @Transactional(readOnly = false)
    public Student login(int id, String pwd){
        return studentDao.login(id,pwd);
    }

    @Transactional(readOnly = true)
    public VStudent getInfor(int id){
        return studentDao.getInfor(id);
    }
}
