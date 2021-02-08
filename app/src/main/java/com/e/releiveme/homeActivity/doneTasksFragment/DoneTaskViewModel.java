package com.e.releiveme.homeActivity.doneTasksFragment;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.e.releiveme.data.Models.Task;
import com.e.releiveme.data.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DoneTaskViewModel extends AndroidViewModel {

    private Repository mRepository;

    public final LiveData<List<Task>> mAllTasks;

    public DoneTaskViewModel(Application application) {
        super(application);
        mRepository = new Repository(application);
        mAllTasks = mRepository.getAllTasks();
        //update("1");
        //update("2");
        //update("3");
        //update("4");
    }

    public void update(String taskID) { mRepository.updateStateTask(taskID); }

    LiveData<List<Task>> getAllTasks() { return mAllTasks; }

    LiveData<List<String>> getTasksLiveData() {
        LiveData<List<Task>> tasksLiveData = mRepository.getAllDoneTasks();
        return Transformations.map(tasksLiveData, userList -> {
            return userList.stream().map(task -> task.getTaskDescription()).collect(Collectors.toList());
        });
    }

}