package com.e.releiveme.alarm;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import com.e.releiveme.data.DateConverter;
import com.e.releiveme.data.Models.Task;

import static android.content.Context.ALARM_SERVICE;
import static java.lang.System.currentTimeMillis;

public class Alarm {
    Context context;
    public Alarm(Context c){
        this.context=c;
        createNotificationChannel();
    }
    public void startAlert(Task task){

        Intent intent = new Intent(context , AlarmReceiver.class);
        intent.putExtra("type",task.getTypeTask());
        intent.putExtra("description",task.getTaskDescription());

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        long triggerMillis= task.getTaskDate()*1000 - currentTimeMillis() ;

        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+triggerMillis, pendingIntent);

        Toast.makeText(context, " Alarm", Toast.LENGTH_LONG).show();
    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            CharSequence name = "channelAlarmNotification";
            String description = "channel for alarm notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notifyAlarm", name, importance);
            channel.setDescription(description);

            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
