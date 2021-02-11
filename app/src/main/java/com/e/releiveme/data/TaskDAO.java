package com.e.releiveme.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.e.releiveme.data.Models.Task;

import java.util.Date;
import java.util.List;

@Dao
public interface  TaskDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Task task);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Task> tasks);

    @Delete
    void delete(Task task);

    @Query("UPDATE task_table SET taskDate = :newDate WHERE taskId = :taskId")
    int updateTour(String taskId , Date newDate);

    @Query("UPDATE task_table SET taskState = 'DONE' WHERE taskId = :taskId")
    void updateStateTask(String taskId);

    @Query("DELETE FROM task_table")
    void deleteAll();

    @Query("SELECT * FROM task_table ORDER BY taskDate ASC")
    LiveData<List<Task>> getOrderedTasks();

    @Query("SELECT * FROM task_table WHERE taskState = 'TODO' ORDER BY taskDate ASC ")
    LiveData<List<Task>> getToDoTasks();

    @Query("SELECT * FROM task_table WHERE taskState = 'DONE' ORDER BY taskDate ASC")
    LiveData<List<Task>> getDoneTasks();
}
