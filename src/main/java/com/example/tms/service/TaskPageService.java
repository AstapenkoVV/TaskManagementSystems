package com.example.tms.service;

import com.example.tms.cotroller.TaskPageDto;
import com.example.tms.model.Author;
import com.example.tms.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskPageService {

    private final TaskService taskService;
    private final AuthorService authorService;

    public Optional<TaskPageDto> findById(Long id) {
        return taskService.findById(id)
                .map(this :: convert);
    }

    public List<TaskPageDto> findAll() {
        return taskService.findAll().stream()
                .map(this :: convert)
                .toList();
    }

    private TaskPageDto convert (Task task) {
        Author author = authorService.findById(task.getAuthorId())
                .orElseThrow();

        TaskPageDto taskPageDto = new TaskPageDto();
        taskPageDto.setTaskId(String.valueOf(task.getTaskId()));
        taskPageDto.setTaskName(task.getTaskName());
        taskPageDto.setDescription(task.getDescription());
        taskPageDto.setStatus(task.getStatus());
        taskPageDto.setPriority(task.getPriority());
        taskPageDto.setComment(task.getComment());
        taskPageDto.setAuthorName(author.getAuthorName());
        taskPageDto.setExecutor(task.getExecutor());

        return taskPageDto;
    }
}
