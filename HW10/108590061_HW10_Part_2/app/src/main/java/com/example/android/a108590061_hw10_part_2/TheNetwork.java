package com.example.android.a108590061_hw10_part_2;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

import java.net.HttpURLConnection;
//import android.net.Uri;
import java.net.URL;
import android.util.Log;

public class TheNetwork {
    private static final String LOG_TAG = TheNetwork.class.getSimpleName();

    static String WebPageSource(String strings ) {

        BufferedReader b_read = null;
        String str_srcs = null;

        HttpURLConnection connect_url = null;

        try {
            URL requestURL = new URL(strings);
            connect_url = (HttpURLConnection) requestURL.openConnection();
            connect_url.setRequestMethod("GET");
            connect_url.connect();

            InputStream inputStream = connect_url.getInputStream();
            b_read = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();

            String the_linewords;
            while ((the_linewords = b_read.readLine()) != null) {
                stringBuilder.append(the_linewords);
                stringBuilder.append("\n");
            }
            if (stringBuilder.length() == 0) { return null; }
            str_srcs = stringBuilder.toString();

        }
        catch (IOException e) { return null; }

        finally {
            if (connect_url != null) { connect_url.disconnect(); }
            if (b_read != null) {
                try { b_read.close(); }
                catch (IOException e) { e.printStackTrace(); }

            }
        }
        Log.d(LOG_TAG, str_srcs);

        return str_srcs;
    }
}
