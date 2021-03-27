package com.example.covidfriendsappthing;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class FriendsClass extends AppCompatActivity {

    List<String> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends_list);

        friends.add("this");
        friends.add("that");

        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, friends);

        ListView listView = (ListView) findViewById(R.id.friendlist);
        listView.setAdapter(arrayAdapter);
    }
}
