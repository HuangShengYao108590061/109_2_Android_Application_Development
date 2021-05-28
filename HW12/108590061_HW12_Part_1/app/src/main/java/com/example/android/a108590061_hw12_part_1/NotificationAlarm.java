package com.example.android.a108590061_hw12_part_1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.app.NotificationManager;
import android.app.PendingIntent;
import androidx.core.app.NotificationCompat;

public class NotificationAlarm extends BroadcastReceiver {

    private static final String primary_channel_name = "Primary";
    private static final int the_notif_num = 0;
    private NotificationManager notif;

    @Override
    public void onReceive(Context context, Intent intent) {
        notif = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        deliverNotification(context);
    }

    private void deliverNotification(Context context) {
        Intent intnt = new Intent(context, MainActivity.class);
        PendingIntent intnt_pdn = PendingIntent.getActivity(context, the_notif_num, intnt, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder build_notif = new NotificationCompat.Builder(context, primary_channel_name);
        build_notif.setSmallIcon(R.drawable.ic_wish_star)
                .setContentTitle(context.getString(R.string.notif_Title))
                .setContentText(context.getString(R.string.notif_txt))
                .setContentIntent(intnt_pdn)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL);
        notif.notify(the_notif_num, build_notif.build());

    }
}