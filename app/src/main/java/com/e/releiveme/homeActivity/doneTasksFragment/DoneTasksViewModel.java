package com.e.releiveme.homeActivity.doneTasksFragment;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.e.releiveme.apiClient.UserService;
import com.e.releiveme.data.Models.Task;
import com.e.releiveme.data.Repository;
import com.e.releiveme.startActivity.StartActivity;

import java.util.List;
import java.util.stream.Collectors;

public class DoneTasksViewModel {
    private Repository mRepository;
    private static UserService service;
    public int selectedTask=-1;


    static String TAG="DoneTasksViewModel";

    public final LiveData<List<Task>> mAllDoneTasks;

    public DoneTasksViewModel(Context context) {
        mRepository = new Repository(context);
        mAllDoneTasks = mRepository.getAllDoneTasks();
        service= new UserService();


    }
    LiveData<List<Task>> getAllDoneTasks() { return mAllDoneTasks; }
    LiveData<List<String>> getTasksLiveData() {
        LiveData<List<Task>> tasksLiveData = mRepository.getAllDoneTasks();
        return Transformations.map(tasksLiveData, userList -> {
            return userList.stream().map(task -> task.getTaskDescription()).collect(Collectors.toList());
        });
    }
}
