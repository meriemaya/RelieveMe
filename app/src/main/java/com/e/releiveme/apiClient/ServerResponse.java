package com.e.releiveme.apiClient;

import com.e.releiveme.data.Models.Task;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import retrofit2.Call;

/**
 * then we need to create another java class file for model the data that we get from response.
 *         file name User.java and then add the following code:
 */
public class ServerResponse  implements Serializable {
            @SerializedName("returned_username")
            private String username;

            @SerializedName("user_birth_date")
            private String userBirthDate;

            @SerializedName("tasks")
            private List<Task> tasks;
            @SerializedName("response_code")
            private int responseCode;

            public ServerResponse(String username, String date, List<Task> tasks, int responseCode){
                this.username = username;
                this.userBirthDate = date;
                this.tasks = tasks;
                this.responseCode = responseCode;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getBirthDate() {
                return userBirthDate;
            }

            public void setBirthDate(String date) {
                this.userBirthDate = date;
            }

            public List<Task> getTasks() {
                return tasks;
            }

            public void setTasks(List<Task> message) {
                this.tasks = message;
            }

            public int getResponseCode() {
                return responseCode;
            }

            public void setResponseCode(int responseCode) {
                this.responseCode = responseCode;
            }
        }
