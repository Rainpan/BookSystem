package com.tpanda.action;


import com.tpanda.entity.table.Root;
import com.tpanda.entity.table.Student;
import com.tpanda.entity.table.Teacher;
import com.tpanda.service.RootService;
import com.tpanda.service.StudentService;
import com.tpanda.service.TeacherService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ParentPackage("struts-default")
public class matterAction extends SetRequest{

    private int id;
    private String pwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    private RootService rootService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public void setRootService(RootService rootService) {
        this.rootService = rootService;
    }

    //登录
    @Action(value = "login",results = {@Result(name = "page_student",location = "/student/index.jsp"),@Result(name = "page_teacher",location = "/teacher/tc_index.jsp"),@Result(name = "failure",location = "/login.jsp")})
    public String login(){
        String type = ServletActionContext.getRequest().getParameter("type");
        //学生
        if (type.equals("1")){
            Student stu = studentService.login(id,pwd);
            if (stu!=null){
                this.setSession("student",stu);
                return "page_student";
            }else {
                this.setRequest("msg","登录失败，请检查用户名与密码");
                return "failure";
            }
        }

        //老师
        if (type.equals("2")){
            Teacher tc = teacherService.login(id,pwd);
            if (tc!=null){
                this.setSession("teacher",tc);
                return "page_teacher";
            }else {
                this.setRequest("msg","登录失败，请检查用户名与密码");
                return "failure";
            }
        }

        //管理员
        if (type.equals("3")){
            Root root = new Root();
            if (root!=null){
                this.setSession("root",root);
                return "page_root";
            }else {
                this.setRequest("msg","登录失败，请检查用户名与密码");
                return "failure";
            }
        }

        return SUCCESS;
    }
}
