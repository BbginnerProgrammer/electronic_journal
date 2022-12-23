package com.example.electronic_journal.service;

import com.example.electronic_journal.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student findById(Long id);
}
