package com.example.tms.cotroller;

import com.example.tms.model.Task;
import com.example.tms.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tms")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTms(@PathVariable Long id) {
        Optional<Task> tk = taskService.findById(id);
        if (tk.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(tk.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAll() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task) {
        task = taskService.create(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> delete (@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
