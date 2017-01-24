package com.example.pranesh.booklistingapp;

import static android.R.attr.name;
import static android.R.attr.thumbnail;

/**
 * Created by pranesh on 12/01/17.
 */

public class Book {

    private String mTitle;
    private String mAuthor;
    private String mUrl;

    public Book(String title, String author,  String url) {
        mTitle = title;
        mAuthor = author;
        mUrl = url;
    }
    public String getTitle() {
        return mTitle;
    }
    public String getAuthor() {
        return mAuthor;
    }
    public String getUrl(){
        return mUrl;
    }
}