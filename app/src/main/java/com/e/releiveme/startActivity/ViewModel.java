package com.e.releiveme.startActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.e.releiveme.alarm.Alarm;
import com.e.releiveme.apiClient.ServerResponse;
import com.e.releiveme.apiClient.UserService;
import com.e.releiveme.data.Models.Task;
import com.e.releiveme.data.Repository;

import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModel implements Callback<ServerResponse> {




    private static UserService service;
    private static int STATE= 0;
    MutableLiveData<Boolean> loaded = new MutableLiveData();
    SharedPreferences sharedPreferences ;
    Repository repository;
    Context context;
    private final static String TAG = "StartActivity";

   public  ViewModel(Context context){
       sharedPreferences =context.getSharedPreferences(StartActivity.SHARED_NAME,0);
        STATE=1;
        this.context=context;
       service = new UserService();
       repository= new Repository(context);

    }


    public void requestProfile(String userId){
       String hash_pw = BCrypt.hashpw(userId,BCrypt.gensalt());
       service.loginGet(userId,hash_pw,this);
    }


    @Override
    public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {

       if(response.body()!=null){
            ServerResponse res = response.body();
            sharedPreferences.edit().putString(StartActivity.USER_NAME,res.getUsername()).commit();
            sharedPreferences.edit().putString(StartActivity.USER_BIRTH_DATE,res.getBirthDate()).commit();
            List<Task> tasks = new ArrayList(res.getTasks());
            repository.insertAllTasks(tasks);
            Alarm alarm;
           for (Task task:tasks) {
               if (! task.getTaskState().equals("1")) {
                   alarm = new Alarm(context);
                   alarm.startAlert(task);
               }

           }



            loaded.setValue(true);
       }else {
           loaded.setValue(false);
       }
    }

    @Override
    public void onFailure(Call<ServerResponse> call, Throwable t) {

        Log.d("Error",t.getMessage());
    }
}
