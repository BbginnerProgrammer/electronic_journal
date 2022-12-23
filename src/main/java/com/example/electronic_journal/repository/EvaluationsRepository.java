package com.example.electronic_journal.repository;

import com.example.electronic_journal.entity.Evaluations;
import com.example.electronic_journal.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface EvaluationsRepository extends CrudRepository<Evaluations, Long> {

    Evaluations findEvaluationsByStudent(Student student);

    Evaluations findByStudent(Student student);


}
