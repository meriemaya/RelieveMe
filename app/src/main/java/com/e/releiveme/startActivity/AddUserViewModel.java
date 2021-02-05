package com.e.releiveme.startActivity;

import com.e.releiveme.data.Models.User;

public class AddUserViewModel {

    private static AddUserViewModel addUser =null;
    private static User watchUser = null;
    private static String  watchUserId;

    protected AddUserViewModel(){
    }

    public static AddUserViewModel getInstance(){
        if (watchUser == null)
            return new AddUserViewModel();
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
