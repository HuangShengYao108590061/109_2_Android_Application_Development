package com.example.android.a108590061_hw12_part_2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.graphics.Color;
import android.view.View;

import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private static final String primary_channel_name = "Primary";
    private static final int the_job_num = 0;
    NotificationManager notif;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotifChannel();

        IntentFilter the_filters = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batt_stats = this.registerReceiver(null, the_filters);
        assert batt_stats != null;

        int plugged_chrg = batt_stats.getIntExtra(BatteryManager.EXTRA_PLUGGED,-1);
        boolean chrg_adpt = plugged_chrg == BatteryManager.BATTERY_PLUGGED_AC;
        boolean chrg_plug_usb = plugged_chrg == BatteryManager.BATTERY_PLUGGED_USB;

        ConnectivityManager mngr_connect = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert mngr_connect != null;
        NetworkInfo wifi_connect_stat_info = mngr_connect.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        assert wifi_connect_stat_info != null;
        if((chrg_plug_usb || chrg_adpt) && wifi_connect_stat_info.isConnected()){ Downloadscheduler(findViewById(R.id.btn_dwnld)); }
    }

    void NotifSend(){
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, primary_channel_name)
                .setContentTitle(getResources().getString(R.string.title_notification))
                .setContentText(getResources().getString(R.string.txt_notification))
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_icon_download)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setAutoCancel(true);
        notif.notify(0, builder.build());
    }

    private void NotifChannel() {
        notif = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(primary_channel_name, getResources().getString(R.string.download_notif), NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription(getResources().getString(R.string.large_file_notif));
            notif.createNotificationChannel(notificationChannel);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void Downloadscheduler(View view) {

        NotifSend();

        JobScheduler the_job_schedule = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        ComponentName name_cmpnt = new ComponentName(getApplicationContext(), DownloadService.class.getName());

        JobInfo.Builder build_job_info = new JobInfo.Builder(the_job_num, name_cmpnt);
        build_job_info.setRequiresCharging(true)
                .setPeriodic(TimeUnit.DAYS.toMillis(1))
                .setRequiresDeviceIdle(true)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED);

        if (Build.VERSION.SDK_INT > 23) { build_job_info.setPeriodic(TimeUnit.DAYS.toMillis(1), TimeUnit.MINUTES.toMillis(5)); }

        JobInfo infos_job = build_job_info.build();
        if (the_job_schedule != null) { the_job_schedule.schedule(infos_job); }
    }



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public class DownloadService extends JobService {
        @Override
        public boolean onStartJob(JobParameters params) {
            NotifSend();
            return false;
        }

        @Override
        public boolean onStopJob(JobParameters params) {
            return true;
        }
    }
}