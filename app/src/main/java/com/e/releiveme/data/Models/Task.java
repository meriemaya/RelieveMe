package com.e.releiveme.data.Models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Entity(tableName = "task_table")
public class Task {

    @PrimaryKey()
    @NonNull
    @ColumnInfo(name = "TaskId")
    @SerializedName("TaskId")
    private int taskId;

    @SerializedName("taskDate")
    @ColumnInfo(name = "taskDate")
    private long taskDate;


    @SerializedName("taskDescription")
    @ColumnInfo(name = "taskDescription")
    private String taskDescription;

    @SerializedName("typeTask")
    @ColumnInfo(name = "typeTask")
    private String typeTask;

    @SerializedName("taskRepetition")
    @ColumnInfo(name = "taskRepetition")
    private String taskRepetition;

    @SerializedName("taskState")
    @ColumnInfo(name = "taskState")
    private Boolean taskState;


    @SerializedName("endTime")
    @ColumnInfo(name = "endTime")
    private  long taskEnd;


    @Ignore
    public Task(int taskId , long taskDate, String taskDescription, String typeTask, String taskRepetition, Boolean taskState, long taskEnd) {

        this.taskId=taskId;
        this.taskDate =taskDate;
        this.taskDescription = taskDescription;
        this.typeTask = typeTask;
        this.taskRepetition = taskRepetition;
        this.taskState = taskState;
        this.taskEnd = taskEnd;
    }
    public Task(){}

    @NonNull
    public int getTaskId() {
        return taskId;
    }

    public long getTaskDate() {
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

    public Boolean getTaskState() {
        return taskState;
    }

    public long getTaskEnd() {
        return taskEnd;
    }

    public void setTaskId(@NonNull int taskId) {
        this.taskId = taskId;
    }

    public void setTaskDate(long taskDate) {
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

    public void setTaskState(Boolean taskState) {
        this.taskState = taskState;
    }

    public void setTaskEnd(long taskEnd) {
        this.taskEnd = taskEnd;
    }
}
