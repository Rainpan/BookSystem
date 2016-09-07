package com.tpanda.entity.table;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class College {
    private int colId;
    private String colName;

    @Id
    @Column(name = "col_id")
    @GenericGenerator(name = "dir",strategy = "increment")
    @GeneratedValue(generator = "dir")
    public int getColId() {
        return colId;
    }

    public void setColId(int colId) {
        this.colId = colId;
    }

    @Column(name = "col_name")
    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }
}
