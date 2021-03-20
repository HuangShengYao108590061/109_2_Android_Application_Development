package com.example.android.a108590061_hw4_part_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    private EditText Websites;
    private EditText Loc;
    private EditText Share_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Websites = findViewById(R.id.editTextweb);
        Loc = findViewById(R.id.editTextlocation);
        Share_text = findViewById(R.id.editTextsharetext);

    }

    public void openWebsite(View view) {

        String url = Websites.getText().toString();

        Uri WebPage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, WebPage);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }


    public void openLocation(View view) {

        String loc = Loc.getText().toString();

        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void shareText(View view) {
        String txt = Share_text.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(txt)
                .startChooser();
    }


    public void Takethispic(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }


    }
}
