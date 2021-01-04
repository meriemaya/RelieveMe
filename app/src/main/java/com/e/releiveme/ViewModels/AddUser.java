package com.e.releiveme.ViewModels;

import com.e.releiveme.Models.User;

public class AddUser {
    User watchUser;
    String watchUserId;
    public AddUser(){
        watchUser= new User();
        watchUserId=watchUser.getUserId();
    }
    public void requestProfile(){
        // send requests to server
    }
    public void getProfile(){
        // receive information profile

        // set information profile in watchUser

    }
}
