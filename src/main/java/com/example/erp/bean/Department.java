package com.example.erp.bean;

import javax.persistence.*;

@Entity
@Table(name = "Department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dept_id;

    @Column(nullable = false)
    private String dname;

    @Column(nullable = false)
    private Integer capacity;

    public Department(Integer dept_id, String dname, Integer capacity) {
        this.dept_id = dept_id;
        this.dname = dname;
        this.capacity = capacity;
    }

    public Department() {

    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
