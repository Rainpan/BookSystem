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

    //查询可以选的课程
    @Action(value = "selectCourse",results = {@Result(name = "success",location = "/student/selectCourse.jsp"),@Result(name = "failure",location = "/student/index.jsp")})
    public String selectCourse(){
        int id = ((Student) this.getSession("student")).getStuId();
        List<VStuSelectCourseEntity> list = classService.studentToClass(id);
        this.setRequest("course",list);
        return SUCCESS;
    }

    //查询已选课程
    @Action(value = "queryCourse",results = {@Result(name = "success",location = "/student/queryCourse.jsp"),@Result(name = "back",location = "/student/backCourse.jsp")})
    public String QueryCourse(){
        List<VStuQueryCourseEntity> list = classService.studentCourse(((Student)this.getSession("student")).getStuId());
        this.setRequest("course",list);

        if ("back".equals(ServletActionContext.getRequest().getParameter("action"))) return "back";

        return SUCCESS;
    }

    //选课
    @Action(value = "sureCourse",results = {@Result(name = "success",location = "/student/01.html"),@Result(name = "failure",location = "/student/01.html")})
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
    @Action(value = "backCourse",results = {@Result(name = "success",location = "/student/01.html"),@Result(name = "failure",location = "/student/01.html")})
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
    @Action(value = "queryStuInfor",results = {@Result(name = "success",location = "/student/stuInfor.jsp")})
    public String getInfor(){
        VStudent student = studentService.getInfor(((Student)this.getSession("student")).getStuId());
        this.setRequest("student",student);
        return SUCCESS;
    }


}
