package com.example.electronic_journal.controller;

import com.example.electronic_journal.entity.Evaluations;
import com.example.electronic_journal.entity.Tasks;
import com.example.electronic_journal.entity.User;
import com.example.electronic_journal.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
public class TasksController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks")
    public String tasksPage(Model model){
        model.addAttribute("tasks", taskRepository.findAll());
        return "tasks";
    }

    @PostMapping("/tasks")
    public String tasksPage(@AuthenticationPrincipal User user,
                            @Valid Tasks tasks,
                            BindingResult bindingResult,
                            Model model) throws IOException {
        if(bindingResult.hasErrors()){
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            model.addAllAttributes(errorsMap);
            model.addAttribute("task", tasks);
        }else {
            taskRepository.save(tasks);
        }
        model.addAttribute("message", null);
        model.addAttribute("tasks", taskRepository.findAll());

        return "tasks";
    }
}
