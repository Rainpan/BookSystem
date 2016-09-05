package com.tpanda.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {
    private int claId;
    private String claName;
    private int claCredit;
    private String desc;

    @Id
    @Column(name = "cla_id")
    @GenericGenerator(name = "dir",strategy = "increment")
    @GeneratedValue(generator = "dir")
    public int getClaId() {
        return claId;
    }

    public void setClaId(int claId) {
        this.claId = claId;
    }

    @Column(name = "cla_name")
    public String getClaName() {
        return claName;
    }

    public void setClaName(String claName) {
        this.claName = claName;
    }

    @Column(name = "cla_credit")
    public int getClaCredit() {
        return claCredit;
    }

    public void setClaCredit(int claCredit) {
        this.claCredit = claCredit;
    }

    @Column(name = "cla_desc")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
