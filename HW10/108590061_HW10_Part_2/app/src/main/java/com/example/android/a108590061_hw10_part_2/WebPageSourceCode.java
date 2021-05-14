package com.example.android.a108590061_hw10_part_2;

//import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.content.Context;

public class WebPageSourceCode extends AsyncTaskLoader<String> {

    private String The_query;

    WebPageSourceCode(Context context, String strings ) {
        super(context);
        The_query = strings;

    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return TheNetwork.WebPageSource(The_query);
    }
}
