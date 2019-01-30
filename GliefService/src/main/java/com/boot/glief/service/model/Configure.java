package com.boot.glief.service.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Configure{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_configure")
    @Column(name ="ID")
    private Integer id;

        @Column(name ="NAME")
    private String name;

        @Column(name ="CREATED_DATE")
    private Date createdDate;

        @Column(name ="CRETED_BY")
    private String createdby;

        @Column(name ="SOLUTION")
    private String solution;

        @Column(name ="MODIFIED_DATE")
    private Date modifiedDate;

    public Configure() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
