package com.example.tms.cotroller;

import lombok.Data;

@Data
public class TaskPageDto {
    private String taskId;
    private String taskName;
    private String description;
    private String status;
    private String priority;
    private String comment;
    private String authorName;
    private String executor;
}
