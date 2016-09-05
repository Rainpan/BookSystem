package com.tpanda.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class class_teacher {
    private int ctId;
    private int claId;
    private int tcId;

    @Id
    @Column(name = "ct_id")
    @GenericGenerator(name = "dir",strategy = "increment")
    @GeneratedValue(generator = "dir")
    public int getCtId() {
        return ctId;
    }

    public void setCtId(int ctId) {
        this.ctId = ctId;
    }

    @Column(name = "cla_id")
    public int getClaId() {
        return claId;
    }

    public void setClaId(int claId) {
        this.claId = claId;
    }

    @Column(name = "tc_id")
    public int getTcId() {
        return tcId;
    }

    public void setTcId(int tcId) {
        this.tcId = tcId;
    }
}
