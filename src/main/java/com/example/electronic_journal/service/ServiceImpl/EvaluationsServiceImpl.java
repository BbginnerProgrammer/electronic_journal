package com.example.electronic_journal.service.ServiceImpl;

import com.example.electronic_journal.entity.Evaluations;
import com.example.electronic_journal.entity.Student;
import com.example.electronic_journal.repository.EvaluationsRepository;
import com.example.electronic_journal.service.EvaluationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EvaluationsServiceImpl implements EvaluationsService {

    @Autowired
    private EvaluationsRepository evaluationsRepository;

//    @Override
//    public List<Evaluations> getAllEvaluations() {
//        return evaluationsRepository.findAll();
//    }

    @Override
    public List<String> getById(Long id) {
        List<String> list = new ArrayList<>();
        list.add(evaluationsRepository.findById(id).get().getMath());
        list.add(evaluationsRepository.findById(id).get().getRussian());
        list.add(evaluationsRepository.findById(id).get().getEnglish());
        list.add(evaluationsRepository.findById(id).get().getPhysical_education());
        return list;
    }





}
