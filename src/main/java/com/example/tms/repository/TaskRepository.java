package com.example.tms.repository;

import com.example.tms.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class TaskRepository {

    private static Long sequence = 1L;
    private final List<Task> tasks = new ArrayList<>();

    public Optional<Task> findById(Long id) {
        return tasks.stream()
                .filter(task -> Objects.equals(task.getTaskId(), id))
                .findFirst();
    }

    public List<Task> getAll() {
        return List.copyOf(tasks);
    }

    public Task create(Task task) {
        task.setTaskId(sequence++);
        tasks.add(task);
        return task;
    }

    public void delete(Long id) {
        tasks.stream()
                .filter(task -> Objects.equals(task.getTaskId(), id))
                .findFirst()
                .ifPresent(tasks::remove);
    }
}
