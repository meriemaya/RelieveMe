package com.e.releiveme.Models;

import java.util.Date;

public class Task {

    private String TaskId;
    private Date taskDate;
    private String taskDescription;
    private String typeTask;
    private String taskRepetition;
    private String taskState = "ENOD";
    private int taskDuration;

    public Task(String taskId, Date taskDate, String taskDescription, String typeTask, String taskRepetition, int taskDuration) {
        TaskId = taskId;
        this.taskDate = taskDate;
        this.taskDescription = taskDescription;
        this.typeTask = typeTask;
        this.taskRepetition = taskRepetition;
        this.taskDuration = taskDuration;
    }

    public String getTaskId() {
        return TaskId;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getTypeTask() {
        return typeTask;
    }

    public String getTaskRepetition() {
        return taskRepetition;
    }

    public int getTaskDuration() {
        return taskDuration;
    }


    //private String idUserHelper;


}
