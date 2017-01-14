package com.example.pranesh.booklistingapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by pranesh on 13/01/17.
 */

public final class QueryUtils {

    private static final String SAMPLE_JSON_RESPONSE = "{}";


    private QueryUtils() {

    }

    public static ArrayList<Book> extractBooKList() {

        ArrayList<Book> books = new ArrayList<>();

        try {
            JSONObject baseJsonResponse = new JSONObject(SAMPLE_JSON_RESPONSE);
            if(baseJsonResponse.has("totalItems")) {
                int totalItems = baseJsonResponse.getInt("totalItems");
                if(totalItems == 0) {
                    return null;
                }
            }
            JSONArray bookArray = baseJsonResponse.getJSONArray("items");
            for (int i = 0; i < bookArray.length(); i++) {
                JSONObject currentBook = bookArray.getJSONObject(i);
                JSONObject properties = currentBook.getJSONObject("volumeInfo");
                String title = properties.getString("title");
                if(properties.has("authors")) {
                    JSONArray authors = properties.getJSONArray("authors");
                    for (int j = 0; j < authors.length(); j++) {
                        String author = authors.getString(j);

                        Book addList = new Book(title, author);
                        books.add(addList);
                    }
                }
            }

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the BookListing JSON results", e);
        }
        // Return the list of earthquakes
        return books;

    }

}

