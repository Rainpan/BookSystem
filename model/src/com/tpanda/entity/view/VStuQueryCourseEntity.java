package com.tpanda.entity.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_stu_query_course")
public class VStuQueryCourseEntity {
    private int 编号;
    private int 学号;
    private String 姓名;
    private String 专业;
    private int 课程编号;
    private String 课程;
    private int 学分;
    private String 老师;
    private int 老师编号;

    @Id
    public int get编号() {
        return 编号;
    }

    public void set编号(int 编号) {
        this.编号 = 编号;
    }

    @Column(name = "学号")
    public int get学号() {
        return 学号;
    }

    public void set学号(int 学号) {
        this.学号 = 学号;
    }

    @Column(name = "姓名")
    public String get姓名() {
        return 姓名;
    }

    public void set姓名(String 姓名) {
        this.姓名 = 姓名;
    }

    @Column(name = "专业")
    public String get专业() {
        return 专业;
    }

    public void set专业(String 专业) {
        this.专业 = 专业;
    }

    @Column(name = "课程编号")
    public int get课程编号() {
        return 课程编号;
    }

    public void set课程编号(int 课程编号) {
        this.课程编号 = 课程编号;
    }

    @Column(name = "课程")
    public String get课程() {
        return 课程;
    }

    public void set课程(String 课程) {
        this.课程 = 课程;
    }

    @Column(name = "学分")
    public int get学分() {
        return 学分;
    }

    public void set学分(int 学分) {
        this.学分 = 学分;
    }

    @Column(name = "老师")
    public String get老师() {
        return 老师;
    }

    public void set老师(String 老师) {
        this.老师 = 老师;
    }

    @Column(name = "老师编号")
    public int get老师编号() {
        return 老师编号;
    }

    public void set老师编号(int 老师编号) {
        this.老师编号 = 老师编号;
    }
}
