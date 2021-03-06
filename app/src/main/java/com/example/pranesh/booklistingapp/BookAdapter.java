package com.example.pranesh.booklistingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by pranesh on 12/01/17.
 */

public class BookAdapter extends ArrayAdapter<Book> {


    public BookAdapter(Context context, List<Book> books){
        super(context,0,books);
    }


    public View getView(int position, View convertView, ViewGroup parent){

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.book_list_item,parent,false);
        }


        Book currentBook = getItem(position);

        TextView titleView = (TextView) listItemView.findViewById(R.id.title);

        titleView.setText(currentBook.getTitle());

        TextView authorVie = (TextView) listItemView.findViewById(R.id.author);

        authorVie.setText(currentBook.getAuthor());

        return listItemView;
    }

}










