package com.example.pranesh.booklistingapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import java.util.ArrayList;
import java.util.List;
import android.app.LoaderManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Book>> {

    public static final String LOG_TAG = MainActivity.class.getName();

    private BookAdapter mAdapter;

    private static final String GBOOKS_REQUEST_URL = " https://www.googleapis.com/books/v1/volumes?q=android&maxResults=10";

    private static final int BOOK_LOADER_ID = 1;

    private TextView mEmptyStateTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView bookListView = (ListView) findViewById(R.id.list);

        mAdapter = new BookAdapter(this, new ArrayList<Book>());

        bookListView.setAdapter(mAdapter);

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        bookListView.setEmptyView(mEmptyStateTextView);


        bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Book currentBook = mAdapter.getItem(position);

                Uri earthquakeUri = Uri.parse(currentBook.getUrl());

                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                startActivity(websiteIntent);
            }
        });


        ConnectivityManager connMgr = (ConnectivityManager)  getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(BOOK_LOADER_ID, null, this);
        } else {
            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);

            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }
   }


    public Loader<List<Book>> onCreateLoader(int i, Bundle bundle) {

        Log.i(LOG_TAG,"TEST: onCreateLoader() called ...");
        return new BookLoader(this, GBOOKS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Book>> loader, List<Book> books) {

        mEmptyStateTextView.setText(R.string.no_books);

        Log.i(LOG_TAG, "TEST: onLoadFinished() called ...");

        mAdapter.clear();

        if (books != null && !books.isEmpty()) {
            mAdapter.addAll(books);
        }
    }


    @Override
    public void onLoaderReset(Loader<List<Book>> loader) {

        Log.i(LOG_TAG,"TEST: onLoaderReset() called ...");
        // Loader reset, so we can clear out our existing data.
        mAdapter.clear();
    }
}
    



