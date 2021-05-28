package com.example.android.a108590061_hw12_part_1;

import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;

import android.os.Build;
import android.os.Bundle;

import android.content.Intent;
import android.graphics.Color;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
public class MainActivity extends AppCompatActivity {

    private static final String primary_channel_name = "Primary";
    private static final int the_notif_num = 0;
    private NotificationManager notif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton toggle_alarm_btn = findViewById(R.id.on_off_btn);
        Intent intnt_notif = new Intent(this, NotificationAlarm.class);
        final boolean set_the_alarm = (PendingIntent.getBroadcast(this, the_notif_num, intnt_notif, PendingIntent.FLAG_NO_CREATE) != null);
        toggle_alarm_btn.setChecked(set_the_alarm);


        final PendingIntent intnt_pdng = PendingIntent.getBroadcast(this, the_notif_num, intnt_notif, PendingIntent.FLAG_UPDATE_CURRENT);
        final AlarmManager set_Alarm = (AlarmManager) getSystemService(ALARM_SERVICE);

        toggle_alarm_btn.setOnCheckedChangeListener
                (new CompoundButton.OnCheckedChangeListener() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onCheckedChanged
                            (CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            if (set_Alarm != null){

                                Calendar the_set_time = Calendar.getInstance();
                                the_set_time.set(Calendar.HOUR, 11);
                                the_set_time.set(Calendar.MINUTE, 11);

                                set_Alarm.setExact(AlarmManager.RTC_WAKEUP, the_set_time.getTimeInMillis(), intnt_pdng);
                                Toast.makeText(MainActivity.this, R.string.alarm_set_on, Toast.LENGTH_LONG).show();

                            }
                        }
                        else {
                            if (set_Alarm != null) {
                                set_Alarm.cancel(intnt_pdng);
                                notif.cancelAll();
                                Toast.makeText(MainActivity.this, R.string.alarm_set_off, Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });
        notif = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotifChannel();
    }



    public void NotifChannel() {

        notif = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            NotificationChannel notificationChannel = new NotificationChannel(primary_channel_name, getString(R.string.alarm_set_txt), NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.BLUE);
            notificationChannel.enableVibration(true);

            notificationChannel.setDescription(getString(R.string.alarm_set_notify));
            notif.createNotificationChannel(notificationChannel);
        }
    }
}
