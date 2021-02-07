package com.e.releiveme.data.Models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class User {
    private String UserId;
    private String FirstName;
    private String FamilyName;
     private Date birthDate;
    private List<Task> taskList;

    public String getUserId() {
        return UserId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getFamilyName() {
        return FamilyName;
    }

    public void setFamilyName(String familyName) {
        FamilyName = familyName;
    }

    public Date getBirthDate() { return birthDate; }

    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public User(){
        this.UserId=UUID.randomUUID().toString();
    }
}
