package com.tpanda.entity.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_student")
public class VStudent {
    private int 编号;
    private int 学号;
    private String 姓名;
    private int 年龄;
    private String 性别;
    private String 专业;
    private String 学院;

    @Id
    @Column(name = "编号")
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

    @Column(name = "年龄")
    public int get年龄() {
        return 年龄;
    }

    public void set年龄(int 年龄) {
        this.年龄 = 年龄;
    }

    @Column(name = "性别")
    public String get性别() {
        return 性别;
    }

    public void set性别(String 性别) {
        this.性别 = 性别;
    }

    @Column(name = "专业")
    public String get专业() {
        return 专业;
    }

    public void set专业(String 专业) {
        this.专业 = 专业;
    }

    @Column(name = "学院")
    public String get学院() {
        return 学院;
    }

    public void set学院(String 学院) {
        this.学院 = 学院;
    }
}
