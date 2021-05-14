package com.example.android.a108590061_hw10_part_2;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.annotation.SuppressLint;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private String types;
    private EditText txt_ed;
    private TextView page_sources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        page_sources = findViewById(R.id.webpage_source_code_shows);
        txt_ed = findViewById(R.id.inp_line);
        Spinner the_protocol_spinner = (Spinner)findViewById(R.id.spinner);

        final ArrayAdapter<CharSequence> adpt_arrs = ArrayAdapter.createFromResource(this, R.array.ProtocolArray, android.R.layout.simple_spinner_item );
        adpt_arrs.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        the_protocol_spinner.setAdapter(adpt_arrs);

        types = the_protocol_spinner.getSelectedItem().toString();
        the_protocol_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) { types = (String) adpt_arrs.getItem(position); }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
        if (getSupportLoaderManager().getLoader(0) != null) { getSupportLoaderManager().initLoader(0, null, this); }
    }

    public void ThePageSourceCode(View view) {

        String the_queries = txt_ed.getText().toString();
        InputMethodManager txts_inp = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        if (txts_inp != null) { txts_inp.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS); }

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;

        if (connMgr != null) { networkInfo = connMgr.getActiveNetworkInfo(); }

        if (networkInfo != null && networkInfo.isConnected() && the_queries.length() != 0) {
            Bundle bndl_query = new Bundle();
            the_queries = types + the_queries;
            bndl_query.putString("queryString", the_queries);
            getSupportLoaderManager().restartLoader(0, bndl_query, this);
            page_sources.setText(R.string.getting_the_source_code);
        }

        else {
            if (the_queries.length() == 0) { page_sources.setText(R.string.no_search_term);
            }
            else { page_sources.setText(R.string.network_error);
            }
        }
    }
    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        String queryString = "";

        if (args != null) { queryString = args.getString("queryString"); }

        return new WebPageSourceCode(this, queryString);
    }
    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) { }

    @SuppressLint("SetTextI18n")
    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String webpage_srcs) {
        if (webpage_srcs == null) { page_sources.setText(R.string.no_results); }
        else { page_sources.setText(webpage_srcs); }
    }

}

