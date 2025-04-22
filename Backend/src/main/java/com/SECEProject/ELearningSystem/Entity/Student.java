package com.SECEProject.ELearningSystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer st_id;

    @Column(nullable = false, length = 50)
    private String st_name;

    @Column(unique = true, nullable = false, length = 100)
    private String st_email;

    @Column(nullable = false, length = 20)
    private String st_phone;

    @Column(nullable = false, length = 100)
    private String st_password;

    @Column(nullable = false, length = 50)
    private String st_profession;

    public Student() {}

    public Student(Integer st_id, String st_name, String st_email, String st_phone, String st_password, String st_profession) {
        this.st_id = st_id;
        this.st_name = st_name;
        this.st_email = st_email;
        this.st_phone = st_phone;
        this.st_password = st_password;
        this.st_profession = st_profession;
    }

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "st_id"),
            inverseJoinColumns = @JoinColumn(name = "c_id")
    )
    private List<Course> courses = new ArrayList<>();

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Integer getSt_id() {
        return st_id;
    }

    public void setSt_id(Integer st_id) {
        this.st_id = st_id;
    }

    public String getSt_name() {
        return st_name;
    }

    public void setSt_name(String st_name) {
        this.st_name = st_name;
    }

    public String getSt_email() {
        return st_email;
    }

    public void setSt_email(String st_email) {
        this.st_email = st_email;
    }

    public String getSt_phone() {
        return st_phone;
    }

    public void setSt_phone(String st_phone) {
        this.st_phone = st_phone;
    }

    public String getSt_password() {
        return st_password;
    }

    public void setSt_password(String st_password) {
        this.st_password = st_password;
    }

    public String getSt_profession() {
        return st_profession;
    }

    public void setSt_profession(String st_profession) {
        this.st_profession = st_profession;
    }
}