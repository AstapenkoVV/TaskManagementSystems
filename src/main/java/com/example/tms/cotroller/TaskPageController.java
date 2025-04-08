package com.example.tms.cotroller;

import com.example.tms.service.TaskPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/home/tms")
@RequiredArgsConstructor
public class TaskPageController {

    private final TaskPageService taskPageService;

    @GetMapping
    public String getAllTasks(Model model) {
        List<TaskPageDto> tasks = taskPageService.findAll();
        model.addAttribute("tasks", tasks);
        return "tasks-page.html";
    }

    @GetMapping("/{id}")
    public String getTaskPage(@PathVariable Long id, Model model) {
        Optional<TaskPageDto> taskOpt = taskPageService.findById(id);
        if (taskOpt.isEmpty()) {
            return "not-found.html";
        }
        model.addAttribute("task", taskOpt.get());
        return "task-page.html";
    }
}
