package com.example.tms.service;

import com.example.tms.model.Task;
import com.example.tms.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskRepository getTaskRepository() {
        return taskRepository;
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> findAll() {
        return taskRepository.getAll();
    }

    public Task create(Task task) {
        return taskRepository.create(task);
    }

    public void delete(Long id) {
        taskRepository.delete(id);
    }
}
