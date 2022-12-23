package com.example.electronic_journal.controller;

import com.example.electronic_journal.entity.Evaluations;
import com.example.electronic_journal.entity.Student;
import com.example.electronic_journal.entity.User;
import com.example.electronic_journal.repository.EvaluationsRepository;
import com.example.electronic_journal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.util.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private EvaluationsRepository evaluationsRepository;

    @GetMapping("/")
    public String greeting(){
        return "greeting";
    }

    @GetMapping("/students")
    public String main(Model model){
        Map<Student, List<Evaluations>> map = new HashMap<>();
        List<Student> studentList = studentService.getAllStudents();
        List<Evaluations> list = new ArrayList<>();
        for (Student student : studentList){
            if (map.containsKey(student)) {
                    map.computeIfAbsent(student, k -> list).add(evaluationsRepository.findEvaluationsByStudent(student));
                } else map.computeIfAbsent(student, k -> new ArrayList<>()).add(evaluationsRepository.findEvaluationsByStudent(student));

        }

        model.addAttribute("students", map);


        return "main";
    }

    @GetMapping("/student/add")
    public String createNewStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "add_student";
    }

    @PostMapping("/student/add")
    public String addStudent(@AuthenticationPrincipal User user,
                             @Valid Student student,
                             BindingResult bindingResult,
                             Model model){
        if(bindingResult.hasErrors()){
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            model.addAllAttributes(errorsMap);
            model.addAttribute("message", student);
        }else {
            model.addAttribute("message", null);

            studentService.saveStudent(student);
            Evaluations evaluations = new Evaluations();
            evaluations.setStudent(student);
            evaluations.setEnglish("");
            evaluations.setMath("");
            evaluations.setRussian("");
            evaluations.setPhysical_education("");
            evaluationsRepository.save(evaluations);
        }
        return "redirect:/students";
    }

    @GetMapping("/student/cancel")
    public String cancelStudent(Model model){
        Map<Student, List<Evaluations>> map = new HashMap<>();
        List<Student> studentList = studentService.getAllStudents();
        List<Evaluations> list = new ArrayList<>();
        for (Student student : studentList){
            if (map.containsKey(student)) {
                map.computeIfAbsent(student, k -> list).add(evaluationsRepository.findEvaluationsByStudent(student));
            } else map.computeIfAbsent(student, k -> new ArrayList<>()).add(evaluationsRepository.findEvaluationsByStudent(student));

        }
        model.addAttribute("students", map);
        return "main";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }


    @RequestMapping("/testpost" )
    @PostMapping
    @ResponseBody
    public String testPost(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String[] line = name.split("_");
        System.out.println(Arrays.stream(line).toList());
        if(line.length == 3){
            Evaluations evaluations = evaluationsRepository.findByStudent(studentService.findById(Long.valueOf(line[1])));
            switch (line[0]) {
                case "math" -> evaluations.setMath(line[2]);
                case "russian" -> evaluations.setRussian(line[2]);
                case "english" -> evaluations.setEnglish(line[2]);
            }
            evaluationsRepository.save(evaluations);
        }else if(line.length == 4){
            Evaluations evaluations = evaluationsRepository.findByStudent(studentService.findById(Long.valueOf(line[2])));
            if(line[0].equals("physical")) {
                evaluations.setPhysical_education(line[3]);
            }
            evaluationsRepository.save(evaluations);
        }
        return name;

    }

    @RequestMapping("/testget" )
    @PostMapping
    @ResponseBody
    public String testGet(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String[] line = name.split("_");
        System.out.println(Arrays.stream(line).toList());
        if(line.length == 3){
            Evaluations evaluations = evaluationsRepository.findByStudent(studentService.findById(Long.valueOf(line[1])));
            switch (line[0]) {
                case "math" -> evaluations.setMath(line[2]);
                case "russian" -> evaluations.setRussian(line[2]);
                case "english" -> evaluations.setEnglish(line[2]);
            }
            evaluationsRepository.save(evaluations);
        }else if(line.length == 4){
            Evaluations evaluations = evaluationsRepository.findByStudent(studentService.findById(Long.valueOf(line[2])));
            if(line[0].equals("physical")) {
                evaluations.setPhysical_education(line[3]);
            }
            evaluationsRepository.save(evaluations);
        }
        return name;
    }
}






















