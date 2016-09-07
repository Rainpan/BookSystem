package com.tpanda.action;

import com.tpanda.entity.table.Student;
import com.tpanda.entity.view.VStuQueryCourseEntity;
import com.tpanda.entity.view.VStuSelectCourseEntity;
import com.tpanda.entity.view.VStudent;
import com.tpanda.service.CourseService;
import com.tpanda.service.StudentService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@ParentPackage("struts-default")
public class StudentAction extends SetRequest {

    private Student student;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService classService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setClassService(CourseService classService) {
        this.classService = classService;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Action(value = "login",results = {@Result(name = "success",location = "/index.jsp"),@Result(name = "failure",location = "/login.jsp")})
    public String login(){
        Student stu = studentService.login(student.getStuId(),student.getStuPwd());
        if (stu!=null){
            this.setSession("student",student);
            return SUCCESS;
        }else {
            this.setRequest("msg","登录失败，请检查用户名与密码");
            return "failure";
        }
    }

    @Action(value = "selectCourse",results = {@Result(name = "success",location = "/selectCourse.jsp"),@Result(name = "failure",location = "/index.jsp")})
    public String selectCourse(){
        int id = ((Student) this.getSession("student")).getStuId();
        List<VStuSelectCourseEntity> list = classService.studentToClass(id);
        this.setRequest("course",list);
        return SUCCESS;
    }

    @Action(value = "sureCourse",results = {@Result(name = "success",location = "/01.html"),@Result(name = "failure",location = "/01.html")})
    public String SureCourse(){
        String[] course = ServletActionContext.getRequest().getParameterValues("select");
        if (course==null){
            return "failure";
        }
        int stuId = ((Student)this.getSession("student")).getStuId();
        classService.addCourse(stuId,course);
        return SUCCESS;
    }

    @Action(value = "queryCourse",results = {@Result(name = "success",location = "/queryCourse.jsp")})
    public String QueryCourse(){
        List<VStuQueryCourseEntity> list = classService.studentCourse(((Student)this.getSession("student")).getStuId());
        this.setRequest("course",list);
        return SUCCESS;
    }

    @Action(value = "queryCourse",results = {@Result(name = "success",location = "/stuInfor.jsp")})
    public String getInfor(){
        VStudent student = studentService.getInfor(((Student)this.getSession("student")).getStuId());
        this.setRequest("student",student);
        return SUCCESS;
    }
}
