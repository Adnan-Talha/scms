package com.admin.scholarship.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students") 
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    
    private Double income;
    
    @Column(name = "tenth_percentage")
    private Double tenthPercentage;  
    
    @Column(name = "twelfth_percentage")
    private Double twelfthPercentage;  

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    public enum Status {
        PENDING, APPROVED, REJECTED
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getTenthPercentage() {
        return tenthPercentage;
    }

    public void setTenthPercentage(Double tenthPercentage) {
        this.tenthPercentage = tenthPercentage;
    }

    public Double getTwelfthPercentage() {
        return twelfthPercentage;
    }

    public void setTwelfthPercentage(Double twelfthPercentage) {
        this.twelfthPercentage = twelfthPercentage;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
