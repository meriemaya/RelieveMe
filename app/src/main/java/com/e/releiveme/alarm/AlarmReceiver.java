package com.e.releiveme.alarm;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.VibrationEffect;
import android.view.View;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.e.releiveme.R;
import com.e.releiveme.data.DateConverter;
import com.e.releiveme.data.Models.Task;
import com.e.releiveme.utils.AlertDialogClass;
import android.os.Vibrator;

import static androidx.core.content.ContextCompat.getSystemService;
import static java.lang.System.currentTimeMillis;

public class AlarmReceiver extends BroadcastReceiver  {
    AlertDialogClass alert;
    Context context;
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,"notifyAlarm")
                .setSmallIcon(context.getResources().getIdentifier("drawable/"+intent.getExtras().getString("type"), null, context.getPackageName()))
                .setVibrate(new long[] {0, 1000, 50, 2000})
                .setContentTitle(intent.getExtras().getCharSequence("description"))
                .setContentText("Maintenant "+DateConverter.dateToString(currentTimeMillis()/1000))
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setColor(context.getColor(R.color.orange));
        NotificationManagerCompat notificationManager=NotificationManagerCompat.from(context);

        notificationManager.notify(200,builder.build());



        Vibrator v = (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(700, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            v.vibrate(700);
        }
    }


}

