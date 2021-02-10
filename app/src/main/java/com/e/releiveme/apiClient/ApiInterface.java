package com.e.releiveme.apiClient;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiInterface {

    // String SERVER_URL = "http://handiman.univ-paris8.fr/~imane/relieveme_php/";
    String SERVER_URL = "http://192.168.1.184/";

    @FormUrlEncoded
    @POST("relieveme_php/updateTask.php")
    Call<ServerResponse> post(
            @Field("method") String method,
            @Field("username") String username,
            @Field("password") String taskId
    );

    //This method is used for "GET"
    @GET("relieveme_php/tasks.php")
    Call<ServerResponse> getUser(
            @Query("method") String method,
            @Query("username") String username,
            @Query("password") String password
    );

}


