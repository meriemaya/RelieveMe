package com.e.releiveme.data;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import com.e.releiveme.data.Models.Task;

import java.util.List;

public class Repository {

    private TaskDAO mTaskDAO;
    private LiveData<List<Task>> mAllTasks;
    private LiveData<List<Task>> allToDoTasks;
    private LiveData<List<Task>> allDoneTasks;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.

    public Repository(Context context ) {
        DBRoom db = DBRoom.getDatabase(context);
        mTaskDAO = db.wordDao();
        mAllTasks = mTaskDAO.getOrderedTasks();
        allToDoTasks = mTaskDAO.getToDoTasks();
        allDoneTasks = mTaskDAO.getDoneTasks();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Task>> getAllTasks() {
        return mAllTasks;
    }

    public LiveData<List<Task>> getAllToDoTasks() {
        return allToDoTasks;
    }

    public void updateStateTask(String taskID){ mTaskDAO.updateStateTask(taskID); }

    public LiveData<List<Task>> getAllDoneTasks() {
        return allDoneTasks;
    }
    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(Task task) {
        DBRoom.databaseWriteExecutor.execute(() -> {
            mTaskDAO.insert(task);
        });
    }

    public void insertAllTasks(List<Task> tasks) {
        DBRoom.databaseWriteExecutor.execute(() -> {
            mTaskDAO.insertAll(tasks);
        });
    }
}
