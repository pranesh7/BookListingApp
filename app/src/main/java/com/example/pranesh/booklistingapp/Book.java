package com.example.pranesh.booklistingapp;

import static android.R.attr.name;

/**
 * Created by pranesh on 12/01/17.
 */

public class Book {

    private String mTitle;
    private String mAuthor;

    public Book(String title, String author) {
        mTitle = title;
        mAuthor = author;
    }
    public String getTitle() {
        return mTitle;
    }
    public String getAuthor() {
        return mAuthor;
    }
}
