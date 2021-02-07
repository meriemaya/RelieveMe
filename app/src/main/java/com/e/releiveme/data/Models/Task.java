package com.e.releiveme.data.Models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "task_table")
public class Task {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "TaskId")
    private int TaskId;

    @ColumnInfo(name = "taskDate")
    private Date taskDate;


    @ColumnInfo(name = "taskDescription")
    private String taskDescription;


    @ColumnInfo(name = "typeTask")
    private String typeTask;

    @ColumnInfo(name = "taskRepetition")
    private String taskRepetition;


    @ColumnInfo(name = "taskState")
    private String taskState;


    @ColumnInfo(name = "taskDuration")
    private int taskDuration;


    public Task(Date taskDate, String taskDescription, String typeTask, String taskRepetition, String taskState, int taskDuration) {
        this.taskDate = taskDate;
        this.taskDescription = taskDescription;
        this.typeTask = typeTask;
        this.taskRepetition = taskRepetition;
        this.taskState = "TODO";
        this.taskDuration = taskDuration;
    }
    public Task(){}

    @NonNull
    public int getTaskId() {
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

    public String getTaskState() {
        return taskState;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public void setTaskId(@NonNull int taskId) {
        TaskId = taskId;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setTypeTask(String typeTask) {
        this.typeTask = typeTask;
    }

    public void setTaskRepetition(String taskRepetition) {
        this.taskRepetition = taskRepetition;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }

    public void setTaskDuration(int taskDuration) {
        this.taskDuration = taskDuration;
    }
}
