package com.e.releiveme.homeActivity.toDoFragment;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.e.releiveme.data.Models.Task;
import com.e.releiveme.data.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TodoTaskViewModel extends AndroidViewModel {

    private Repository mRepository;

    public final LiveData<List<Task>> mAllTasks;

    public TodoTaskViewModel(Application application) {
        super(application);
        mRepository = new Repository(application);
        mAllTasks = mRepository.getAllTasks();
        //insert(new Task(new Date() , "Course", "quot", "d", "TODO", 45));
        //insert(new Task(new Date() , "La poste", "quot", "w", "TODO", 20));
        //insert(new Task(new Date() , "Medoc", "quot", "d", "DONE", 2));
        //insert(new Task(new Date() , "repas Familial", "quot", "w", "DONE", 60));
    }

    public void insert(Task task) { mRepository.insert(task); }

    LiveData<List<Task>> getAllTasks() { return mAllTasks; }

    LiveData<List<String>> getTasksLiveData() {
        LiveData<List<Task>> tasksLiveData = mRepository.getAllToDoTasks();
        return Transformations.map(tasksLiveData, userList -> {
            return userList.stream().map(task -> task.getTaskDescription()).collect(Collectors.toList());
        });
    }

}