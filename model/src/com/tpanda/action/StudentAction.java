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

    //学生登录
    @Action(value = "login",results = {@Result(name = "success",location = "/index.jsp"),@Result(name = "failure",location = "/login.jsp")})
    public String login(){
        String type = ServletActionContext.getRequest().getParameter("type");
        if (type.equals("1")){

        }
        if (type.equals("2")){

        }
        if (type.equals("3")){

        }

        Student stu = studentService.login(student.getStuId(),student.getStuPwd());
        if (stu!=null){
            this.setSession("student",stu);
            return SUCCESS;
        }else {
            this.setRequest("msg","登录失败，请检查用户名与密码");
            return "failure";
        }
    }

    //查询可以选的课程
    @Action(value = "selectCourse",results = {@Result(name = "success",location = "/selectCourse.jsp"),@Result(name = "failure",location = "/index.jsp")})
    public String selectCourse(){
        int id = ((Student) this.getSession("student")).getStuId();
        List<VStuSelectCourseEntity> list = classService.studentToClass(id);
        this.setRequest("course",list);
        return SUCCESS;
    }

    //查询已选课程
    @Action(value = "queryCourse",results = {@Result(name = "success",location = "/queryCourse.jsp"),@Result(name = "back",location = "/backCourse.jsp")})
    public String QueryCourse(){
        List<VStuQueryCourseEntity> list = classService.studentCourse(((Student)this.getSession("student")).getStuId());
        this.setRequest("course",list);

        if ("back".equals(ServletActionContext.getRequest().getParameter("action"))) return "back";

        return SUCCESS;
    }

    //选课
    @Action(value = "sureCourse",results = {@Result(name = "success",location = "/01.html"),@Result(name = "failure",location = "/01.html")})
    public String SureCourse(){
        String[] parameters = ServletActionContext.getRequest().getParameterValues("select");
        if (parameters==null){
            return "failure";
        }

        String[] courses = new String[parameters.length];
        String[] tcsId = new String[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            String[] str = parameters[i].split(";");
            courses[i]=str[0];
            tcsId[i]=str[1];
        }


        int stuId = ((Student)this.getSession("student")).getStuId();
        classService.addCourse(stuId,courses,tcsId);
        return SUCCESS;
    }

    //退选课程
    @Action(value = "backCourse",results = {@Result(name = "success",location = "/01.html"),@Result(name = "failure",location = "/01.html")})
    public String deleteCourse(){
        String[] course = ServletActionContext.getRequest().getParameterValues("select");
        if (course==null){
            return "failure";
        }
        int stuId = ((Student)this.getSession("student")).getStuId();
        classService.deleteCourse(stuId,course);
        return SUCCESS;
    }

    //查询个人信息
    @Action(value = "queryInfor",results = {@Result(name = "success",location = "/stuInfor.jsp")})
    public String getInfor(){
        VStudent student = studentService.getInfor(((Student)this.getSession("student")).getStuId());
        this.setRequest("student",student);
        return SUCCESS;
    }


}
