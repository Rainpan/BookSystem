package com.tpanda.entity.table;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Teacher {
    private int tcId;
    private String tcName;
    private String tcPwd;
    private String sex;
    private int tcAge;
    private int proId;

    @Id
    @Column(name = "tc_id")
    @GenericGenerator(name = "dir",strategy = "increment")
    @GeneratedValue(generator = "dir")
    public int getTcId() {
        return tcId;
    }

    public void setTcId(int tcId) {
        this.tcId = tcId;
    }

    @Column(name = "tc_name")
    public String getTcName() {
        return tcName;
    }

    public void setTcName(String tcName) {
        this.tcName = tcName;
    }

    @Column(name = "tc_pwd")
    public String getTcPwd() {
        return tcPwd;
    }

    public void setTcPwd(String tcPwd) {
        this.tcPwd = tcPwd;
    }

    @Column(name = "tc_sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Column(name = "tc_age")
    public int getTcAge() {
        return tcAge;
    }

    public void setTcAge(int tcAge) {
        this.tcAge = tcAge;
    }

    @Column(name = "pro_id")
    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }
}
