package com.example.tms.model;

import lombok.Data;

@Data
public class Task {
    private Long taskId;
    private String taskName;
    private String description;
    private String status;
    private String priority;
    private String comment;
    private Long authorId;
    private String executor;
}
