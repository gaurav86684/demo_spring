package com.airtel.ytl.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_rollno_generator")
    @SequenceGenerator(name = "student_rollno_generator", sequenceName = "student_rollno_generator",
            allocationSize = 1, initialValue = 1)

    private Integer rollNo;
    private String  name;
    private Integer age;

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
