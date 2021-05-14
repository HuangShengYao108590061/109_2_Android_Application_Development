package com.example.android.a108590061_HW10_Part_1;

import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ProgressBar TheBar;
    private static final String TEXT_STATE = "currentText";
    private TextView TheText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TheBar = findViewById(R.id.the_p_bar);
        TheText = findViewById(R.id.textView1);
        if (savedInstanceState != null) { TheText.setText(savedInstanceState.getString(TEXT_STATE)); }
    }

    public void startTask(View view) {
        TheText.setText(R.string.napping);
        new SimpleAsyncTask(TheText,TheBar).execute();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TEXT_STATE, TheText.getText().toString());
    }
}
