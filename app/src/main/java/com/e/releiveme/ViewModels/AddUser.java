package com.e.releiveme.ViewModels;

import com.e.releiveme.Models.User;

public class AddUser {

    private static AddUser addUser =null;
    private static User watchUser = null;
    private static String  watchUserId;

    protected AddUser(){
    }

    public static AddUser getInstance(){
        if (watchUser == null)
            return new AddUser();
        return addUser;

    }
    public static String getWatchUserId() {
        return watchUserId;
    }
    public static void setWatchUser(){
        watchUser =new User();
        watchUserId=watchUser.getUserId();
        // requestProfile
    }

    public User getWatchUser(){
        return watchUser;
    }

    public void requestProfile(){
        // send requests to server
    }
    public void getProfile(){
        // receive information profile

        // set information profile in watchUser

    }
}
