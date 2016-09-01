package com.tpanda.action;

import com.tpanda.service.StudentService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ParentPackage("struts-default")
public class StudentAction extends SetRequest {

    private String name;
    private String pwd;

    @Autowired
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
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

        for (String s:name.split("")){
            if (s.matches("\\D")){
                this.setRequest("msg","学号不能包含字母");
                return "failure";
            }
        }
        boolean b = studentService.login(name,pwd);
        if (b==true){
            System.out.println("hello world");
            return SUCCESS;
        }else {
            this.setRequest("msg","登录失败，请检查用户名与密码");
            return "failure";
        }

    }
}
