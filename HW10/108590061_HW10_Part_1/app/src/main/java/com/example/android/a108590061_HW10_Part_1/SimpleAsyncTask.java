package com.example.android.a108590061_HW10_Part_1;


import android.widget.TextView;
import android.widget.ProgressBar;
import android.view.View;
import android.os.AsyncTask;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void,Integer, String> {


    private WeakReference<ProgressBar> TheBar;
    private WeakReference<TextView> TheText;

    SimpleAsyncTask(TextView tv,ProgressBar the_bar) {
        TheBar = new WeakReference<>(the_bar);
        TheText = new WeakReference<>(tv);
    }

    @Override
    protected String doInBackground(Void... voids) {

        Random num_rdm = new Random();

        int rnd_num = num_rdm.nextInt(11);
        int the_time = (rnd_num * 500);
        int time_slp_chunks = the_time /10;

        for(int i = 0; i < 10; i++) {

            try { Thread.sleep(time_slp_chunks); }
            catch (InterruptedException e) { e.printStackTrace(); }

            int progress_one = ((i+1)*100);
            int progress_chunks = 10;
            int progress_sec = (progress_one)/progress_chunks;
            publishProgress(progress_sec);
        }
        return "Awake at last after sleeping for " + the_time + " milliseconds!";
    }

    @Override
    protected void onProgressUpdate(Integer... the_vals){ TheBar.get().setProgress(the_vals[0]); }

    @Override
    protected void onPostExecute(String result) { TheText.get().setText(result); }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        TheBar.get().setVisibility(View.VISIBLE);
    }
}
