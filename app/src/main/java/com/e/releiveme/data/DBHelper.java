package com.e.releiveme.data;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.e.releiveme.Models.Task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*public class DBHelper  extends SQLiteOpenHelper {

    private static final String TAG = "SQLite";
    //
    public static final String DATABASE_NAME="relieve.db";
    public static final int DATABASE_VERSION=1;

    //Tasks table
    private static final String TABLE_TASKS="Tasks";

    //
    private static final String COLUMN_TASK_ID ="TaskId";
    private static final String COLUMN_TASK_NAME ="TaskName";
    private static final String COLUMN_TASK_DATE="TaskDate";
    private static final String COLUMN_TASK_TYPE="TaskType";
    private static final String COLUMN_TASK_DURATION="TaskDuration";
    private static final String COLUMN_TASK_REPETITION= "TaskRepetition";

    private static DBHelper mInstance = null;

    public static DBHelper getInstance(Context ctx) {


        if (mInstance == null) {
            mInstance = new DBHelper(ctx);
        }
        return mInstance;
    }

    private DBHelper( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "MyDatabaseHelper.onCreate ... ");
        // Script.
        String script = "CREATE TABLE " + TABLE_TASKS + "("
                + COLUMN_TASK_ID + " INTEGER PRIMARY KEY," + COLUMN_TASK_NAME + " TEXT,"
                + COLUMN_TASK_DATE + " DATE, " + COLUMN_TASK_TYPE + " TEXT," + COLUMN_TASK_DURATION
                +" TEXT,"+COLUMN_TASK_REPETITION +" TEXT );";
        // Execute Script.
        db.execSQL(script);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "MyDatabaseHelper.onUpgrade ... ");
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);

        // Create tables again
        onCreate(db);

    }
    public void addMachine(Task task) {
        Log.i(TAG, "MyDatabaseHelper.addNote ... " + task.getTaskDescription());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TASK_NAME, task.getTaskDescription());
        values.put(COLUMN_TASK_DATE, String.valueOf(task.getTaskDate()));
        values.put(COLUMN_TASK_TYPE,task.getTypeTask());
        values.put(COLUMN_TASK_DURATION,task.getTaskDuration());
        values.put(COLUMN_TASK_REPETITION,task.getTaskRepetition());

        // Inserting Row
        db.insert(TABLE_TASKS, null, values);

        // Closing database connection
        db.close();
    }


    public Task getTask(int id) {
        Log.i(TAG, "MyDatabaseHelper.getNote ... " + id);

        SQLiteDatabase db = this.getReadableDatabase();
        DateFormat iso8601Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Cursor cursor = db.query(TABLE_TASKS, new String[] { COLUMN_TASK_ID,
                        COLUMN_TASK_NAME, COLUMN_TASK_DATE, COLUMN_TASK_TYPE,
                        COLUMN_TASK_DURATION,COLUMN_TASK_REPETITION }, COLUMN_TASK_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Task machine = new Task(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TASK_ID)),
                iso8601Format.parse(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TASK_DATE))),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TASK_NAME)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TASK_TYPE)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TASK_REPETITION)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TASK_DURATION)));
        // return note
        return machine;
    }


    public List<MachineModel> getAllMachines() {
        Log.i(TAG, "MyDatabaseHelper.getAllNotes ... " );

        List<MachineModel> machineList = new ArrayList<MachineModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MACHINES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                MachineModel machine = new MachineModel();
                machine.setIdMachine(Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MACHINES_ID))));
                machine.setNameMachine(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MACHINES_NAME)));
                machine.setIPMachine(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MACHINES_IP)));
                machine.setPort(Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MACHINES_PORT))));
                // Adding note to list
                machineList.add(machine);
            } while (cursor.moveToNext());
        }

        // return note list
        return machineList;
    }

    public int getMachinesCount() {
        Log.i(TAG, "DBHELPER.getMachinesCount ... " );

        String countQuery = "SELECT  * FROM " + TABLE_MACHINES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        // return count
        return count;
    }



    public void deleteNote(MachineModel machine) {
        Log.i(TAG, "MyDatabaseHelper.updateNote ... " + machine.getName() );

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MACHINES, COLUMN_MACHINES_ID + " = ?",
                new String[] { String.valueOf(machine.getId()) });
        db.close();
    }

}*/