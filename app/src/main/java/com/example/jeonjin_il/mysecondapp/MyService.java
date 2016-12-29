package com.example.jeonjin_il.mysecondapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by jeonjin-il on 2016. 12. 29..
 */

public class MyService extends Service {

    private Notification.Builder builder;
    private NotificationManager nm;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"HI I`m Service",Toast.LENGTH_LONG).show();
        Intent intent1 = new Intent(this, MainActivity.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent1, 0);
        builder = new Notification.Builder(this);
        builder.setSmallIcon(R.drawable.main);
        builder.setTicker("물좀먹어라!");
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle("물먹을 시간이에요.");
        builder.setContentText("건강한물 먹고 건강챙기세요");
        builder.setContentIntent(pendingIntent);
        nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(123456, builder.build());

        return START_REDELIVER_INTENT;
    }
}
