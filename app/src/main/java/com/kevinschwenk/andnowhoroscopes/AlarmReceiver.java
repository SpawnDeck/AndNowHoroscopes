package com.kevinschwenk.andnowhoroscopes;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Kevin on 2/22/2017.
 */

public class AlarmReceiver extends BroadcastReceiver {

    public static final IntentFilter INTENT_FILTER = new IntentFilter("alarm");

    MainActivity main = null;
    void setMainActivityHandler(MainActivity main){
        this.main=main;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        String text;

        if (main != null)
            text = main.updateHoroscope();
        else
            text = "RIP";

        /*
        SharedPreferences sign = MainActivity.getSharedPreferences(signKey, Context.MODE_PRIVATE);
        String text = sign.getString(signKey, null);
        */
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("Daily Horoscope")
                        .setContentText(text)
                        .setAutoCancel(true);
        Intent resultIntent = new Intent(context, MainActivity.class);
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        context,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        Notification notification = new NotificationCompat.BigTextStyle(mBuilder).bigText(text).build();

        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);

        /*
        Intent notificationIntent = new Intent(context, NotificationPublisher.class);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, 1);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        */

    }
}
