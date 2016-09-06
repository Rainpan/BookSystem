package com.tpanda.action;

import com.tpanda.entity.Course;
import com.tpanda.entity.Student;
import com.tpanda.entity.VStuSelectCourseEntity;
import com.tpanda.service.CourseService;
import com.tpanda.service.StudentService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@ParentPackage("struts-default")
public class StudentAction extends SetRequest {

    private String name;
    private String pwd;

    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Autowired
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @Autowired
    private CourseService classService;

    public void setClassService(CourseService classService) {
        this.classService = classService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Action(value = "login",results = {@Result(name = "success",location = "/index.jsp"),@Result(name = "failure",location = "/login.jsp")})
    public String login(){

/*        for (String s:name.split("")){
            if (s.matches("\\D")){
                this.setRequest("msg","学号不能包含字母");
                return "failure";
            }
        }*/
        System.out.println(student.getStuId());

        boolean b = studentService.login(student.getStuId(),student.getStuPwd());
        if (b==true){
            List<VStuSelectCourseEntity> list = classService.studentToClass(Integer.parseInt(name));
            this.setSession("name",name);
            this.setSession("pwd",pwd);
            this.setRequest("class",list);
            return SUCCESS;
        }else {
            this.setRequest("msg","登录失败，请检查用户名与密码");
            return "failure";
        }
    }

    @Action(value = "selectCourse",results = {@Result(name = "success",location = "/selectCourse.jsp"),@Result(name = "failure",location = "/index.jsp")})
    public String selectCourse(){
        System.out.println("hello");
        int id = Integer.parseInt((String) this.getSession("name"));
        System.out.println(id);
        List<VStuSelectCourseEntity> list = classService.studentToClass(id);
        for (VStuSelectCourseEntity v:list){
            System.out.println(v.get课程());
        }
        this.setRequest("course",list);
        return SUCCESS;
    }
}
