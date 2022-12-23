package com.example.electronic_journal;

import com.example.electronic_journal.entity.Evaluations;
import com.example.electronic_journal.entity.Student;
import com.example.electronic_journal.repository.EvaluationsRepository;
import com.example.electronic_journal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElectronicJournalApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ElectronicJournalApplication.class, args);
    }

    @Autowired
    private EvaluationsRepository evaluationsRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
//        Evaluations evaluations = new Evaluations("2","2","2","2", studentRepository.findById(1L).get());
//        evaluationsRepository.save(evaluations);
    }

}
