package com.e.releiveme.homeActivity.toDoFragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.e.releiveme.apiClient.ServerResponse;
import com.e.releiveme.apiClient.UserService;
import com.e.releiveme.data.Models.Task;
import com.e.releiveme.data.Repository;
import com.e.releiveme.startActivity.StartActivity;
import com.e.releiveme.startActivity.ViewModel;

import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoTaskViewModel implements Callback<ServerResponse> {

    private Repository mRepository;
    private static UserService service;
    public int selectedTask=-1;
    SharedPreferences sharedPreferences ;
    Context context;
    static String TAG="toDoTaskViewModel";

    public final LiveData<List<Task>> mAllToDoTasks;


    public TodoTaskViewModel(Context context) {
        this.context=context;
        mRepository = new Repository(context);
        mAllToDoTasks = mRepository.getAllToDoTasks();
        service= new UserService();
        sharedPreferences= context.getSharedPreferences(StartActivity.SHARED_NAME,0);

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
        String userId= sharedPreferences.getString(StartActivity.USER_KEY,null);
        String hash_pw = BCrypt.hashpw(userId,BCrypt.gensalt());
        service.updateTask(userId,hash_pw,taskId, this);
        service.loginGet(userId,hash_pw, this);

    }
    public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {

        if(response.body()!=null){
            ServerResponse res = response.body();
            List<Task> tasks = new ArrayList(res.getTasks());
            mRepository.insertAllTasks(tasks);

        }
    }

    @Override
    public void onFailure(Call<ServerResponse> call, Throwable t) {
        Log.d("Error",t.getMessage());
    }

}