package com.example.covidfriendsappthing;

import android.content.Intent;
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

        friends.add("Viki");
        friends.add("Thaarukan");
        friends.add("Adhithi");
        friends.add("Dyuti");
        friends.add("Alex");

        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, friends);

        ListView listView = (ListView) findViewById(R.id.friendlist);
        listView.setAdapter(arrayAdapter);

        Intent myGroupsIntent = new Intent(FriendsClass.this, CreateGroupClass.class);

        listView.setOnItemClickListener((parent, view, position, id) -> {

            int setBubble = -1;

            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                setBubble = extras.getInt("Setter");
            }

            String selectedFriend = listView.getItemAtPosition(position).toString();

            myGroupsIntent.putExtra("Selected", selectedFriend);
            myGroupsIntent.putExtra("Setter", setBubble);
            startActivity(myGroupsIntent);

        });
    }
}
