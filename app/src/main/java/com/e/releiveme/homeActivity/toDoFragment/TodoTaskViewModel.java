package com.e.releiveme.homeActivity.toDoFragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.e.releiveme.apiClient.UserService;
import com.e.releiveme.data.Models.Task;
import com.e.releiveme.data.Repository;
import com.e.releiveme.startActivity.StartActivity;

import org.mindrot.jbcrypt.BCrypt;

import java.util.List;
import java.util.stream.Collectors;

public class TodoTaskViewModel  {

    private Repository mRepository;
    private static UserService service;
    public int selectedTask=-1;
    SharedPreferences sharedPref ;

    static String TAG="toDoTaskViewModel";

    public final LiveData<List<Task>> mAllToDoTasks;


    public TodoTaskViewModel(Context context) {
        mRepository = new Repository(context);
        mAllToDoTasks = mRepository.getAllToDoTasks();
        service= new UserService();
        sharedPref= context.getSharedPreferences(StartActivity.SHARED_NAME,0);

    }

    public void insert(Task task) { mRepository.insert(task); }

    LiveData<List<Task>> getAllToDoTasks() { return mAllToDoTasks; }


    LiveData<List<String>> getTasksLiveData() {
        LiveData<List<Task>> tasksLiveData = mRepository.getAllToDoTasks();
        return Transformations.map(tasksLiveData, userList -> {
            return userList.stream().map(task -> task.getTaskDescription()).collect(Collectors.toList());
        });
    }


    /**
     *
     */
    public void updateTaskDone(){
        String taskId = String.valueOf(mAllToDoTasks.getValue().get(selectedTask).getTaskId());
        String username= sharedPref.getString(StartActivity.USER_NAME,null);
        String hash_pw = BCrypt.hashpw(username,BCrypt.gensalt());
        service.updateTask(username,hash_pw,taskId);
    }

}