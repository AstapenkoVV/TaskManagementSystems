package com.example.tms.cotroller;

import com.example.tms.model.Author;
import com.example.tms.model.Task;
import com.example.tms.service.AuthorService;
import com.example.tms.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/home/tms")
@RequiredArgsConstructor
public class TaskPageController {

    private final TaskService taskService;
    private final AuthorService authorService;

    @GetMapping("/{id}")
    public String getTaskPage(@PathVariable Long id, Model model){

        Optional<Task> taskOpt = taskService.findById(id);
        if(taskOpt.isEmpty()){
            //return not-found.hnml
            return "not-found.html";
        }

         Task task = taskOpt.get();
        Author author = authorService.findById(task.getAuthorId())
                .orElseThrow();

        model.addAttribute("taskId", task.getTaskId());
        model.addAttribute("taskName", task.getTaskName());
        model.addAttribute("description", task.getDescription());
        model.addAttribute("status", task.getStatus());
        model.addAttribute("priority", task.getPriority());
        model.addAttribute("comment", task.getComment());
        model.addAttribute("authorName", author.getAuthorName());
        model.addAttribute("executor", task.getExecutor());
         return "task-page.html";
    }

}
