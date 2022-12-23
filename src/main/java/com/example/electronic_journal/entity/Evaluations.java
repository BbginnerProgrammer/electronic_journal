package com.example.electronic_journal.entity;

import javax.persistence.*;
import java.util.Optional;

import com.example.electronic_journal.entity.Student;


@Entity
public class Evaluations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "math")
    private String math;

    @Column(name = "russian")
    private String russian;

    @Column(name = "english")
    private String english;

    @Column(name = "physical_education")
    private String physical_education;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;


    public Evaluations() {
    }

    public Evaluations(String math, String russian, String english, String physical_education, Student student) {
        this.math = math;
        this.russian = russian;
        this.english = english;
        this.student = student;
        this.physical_education = physical_education;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public String getRussian() {
        return russian;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setRussian(String russian) {
        this.russian = russian;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getPhysical_education() {
        return physical_education;
    }

    public void setPhysical_education(String physical_education) {
        this.physical_education = physical_education;
    }
}
