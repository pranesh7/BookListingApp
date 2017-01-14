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

        ArrayList<Book> books = new  ArrayList<>();
        books.add(new Book("Learning android","Dale Cargnie"));
        books.add(new Book("HighPerformance android","Dale Cargnie"));
        books.add(new Book("Programming","Dale Cargnie"));
        books.add(new Book("Memory Performance","Dale Cargnie"));
        books.add(new Book("Updating the UI's","Dale Cargnie"));
        books.add(new Book("Design Enhancements","Dale Cargnie"));
        books.add(new Book("Advance Programming","Dale Cargnie"));

        ListView bookListView = (ListView) findViewById(R.id.list);

        BookAdapter adapter = new BookAdapter(
                this, books);

        bookListView.setAdapter(adapter);

    }
}


