package com.tpanda.entity.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_tc_query_course")
public class VTcQueryCourse {
    private int 编号;
    private int 老师编号;
    private String 老师名字;
    private int 课程编号;
    private String 课程名字;
    private int 学生学号;
    private String 学生名字;
    private String 学生专业;

    @Id
    public int get编号() {
        return 编号;
    }

    public void set编号(int 编号) {
        this.编号 = 编号;
    }

    @Column(name = "老师编号")
    public int get老师编号() {
        return 老师编号;
    }

    public void set老师编号(int 老师编号) {
        this.老师编号 = 老师编号;
    }

    @Column(name = "老师名字")
    public String get老师名字() {
        return 老师名字;
    }

    public void set老师名字(String 老师名字) {
        this.老师名字 = 老师名字;
    }

    @Column(name = "课程编号")
    public int get课程编号() {
        return 课程编号;
    }

    public void set课程编号(int 课程编号) {
        this.课程编号 = 课程编号;
    }

    @Column(name = "课程名字")
    public String get课程名字() {
        return 课程名字;
    }

    public void set课程名字(String 课程名字) {
        this.课程名字 = 课程名字;
    }

    @Column(name = "学生学号")
    public int get学生学号() {
        return 学生学号;
    }

    public void set学生学号(int 学生学号) {
        this.学生学号 = 学生学号;
    }

    @Column(name = "学生名字")
    public String get学生名字() {
        return 学生名字;
    }

    public void set学生名字(String 学生名字) {
        this.学生名字 = 学生名字;
    }

    @Column(name = "学生专业")
    public String get学生专业() {
        return 学生专业;
    }

    public void set学生专业(String 学生专业) {
        this.学生专业 = 学生专业;
    }
}
