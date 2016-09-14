package com.tpanda.action;

import com.tpanda.entity.table.Teacher;
import com.tpanda.entity.view.VTcQueryCourse;
import com.tpanda.entity.view.VTeacher;
import com.tpanda.service.TeacherService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
@ParentPackage("struts-default")
public class TeacherAction extends SetRequest{

    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Autowired
    private TeacherService teacherService;

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    //获取老师个人信息
    @Action(value = "queryTcInfor",results = {@Result(name = "success",location = "/teacher/tcInfor.jsp")})
    public String getInfo(){
        VTeacher teacher = teacherService.getInfor(((Teacher)this.getSession("teacher")).getTcId());
        this.setRequest("teacher",teacher);
        return SUCCESS;
    }

    //获取老师教的课程的学生
    @Action(value = "queryOfStudent",results = {@Result(name = "success",location = "/teacher/queryOfStu.jsp")})
    public String getTcCourseStu(){
        List<VTcQueryCourse> ofStu = teacherService.getCourseOfStu(((Teacher)this.getSession("teacher")).getTcId());
        this.setRequest("ofStu",ofStu);
        return SUCCESS;
    }
    
}
