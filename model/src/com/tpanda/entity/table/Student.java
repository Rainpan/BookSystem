package com.tpanda.entity.table;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
    private int stuId;
    private String stuName;
    private String stuPwd;
    private String sex;
    private int proId;

    @Id
    @Column(name = "stu_id")
    @GenericGenerator(name = "dir",strategy = "increment")
    @GeneratedValue(generator = "dir")
    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    @Column(name = "stu_name")
    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    @Column(name = "stu_pwd")
    public String getStuPwd() {
        return stuPwd;
    }

    public void setStuPwd(String stuPwd) {
        this.stuPwd = stuPwd;
    }

    @Column(name = "stu_sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Column(name = "pro_id")
    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }
}
