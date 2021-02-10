package com.e.releiveme.apiClient;

import android.util.Log;

import com.e.releiveme.data.Models.Task;
import com.e.releiveme.data.Models.User;
import com.squareup.otto.Produce;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserService {

    ApiInterface api ;
    public UserService() {
         api = new Retrofit.Builder()
                .baseUrl(ApiInterface.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface.class);
    }
    public void loginGet(String username, String password , Callback<ServerResponse> callback) {
        Call<ServerResponse> call = api.getUser("user_tasks", username, password);
        call.enqueue(callback);
    }
    public void updateTask(String username, String password , String taskId) {
        Call<ServerResponse> call = api.post("update_task", username, password);

    }
    public void duplicateTask(String username, String password ,String taskId) {
        Call<ServerResponse> call = api.post("duplicate_task", username, password);

    }
}
