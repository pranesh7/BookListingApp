package com.example.pranesh.booklistingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Book> books = QueryUtils.extractBooKList();

        ListView bookListView = (ListView) findViewById(R.id.list);

        BookAdapter adapter = new BookAdapter(
                this, books);

        bookListView.setAdapter(adapter);

    }
}


