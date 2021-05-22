package com.android.fundamentals.a108590061_hw11_part_1;


import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;

import android.arch.core.BuildConfig;
import android.widget.Toast;

public class TheReceiver extends BroadcastReceiver {

    private static final String rdm_nums = "The_random_generated_number";
    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        String stringNumber = intent.getStringExtra(rdm_nums);
        int the_nums = Integer.valueOf(stringNumber);
        if (intentAction != null) {
            String toastMessage = context.getString(R.string.unknown_action);
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = context.getString(R.string.power_connected);
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = context.getString(R.string.power_disconnected);
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    toastMessage = context.getString(R.string.custom_broadcast_toast);
                    break;
            }
            int num_sqr = the_nums*the_nums;
            String msgs = "Square of the random number is ";
            Toast.makeText(context, toastMessage + "\n" + msgs + num_sqr, Toast.LENGTH_SHORT).show();
        }
    }
}
