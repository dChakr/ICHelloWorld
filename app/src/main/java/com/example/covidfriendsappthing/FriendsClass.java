package com.example.covidfriendsappthing;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class FriendsClass extends AppCompatActivity {

    // friendsToAdd initially is cloned from the FriendList of the user.
    // friendsToAdd will be modified here so that's why you need a clone here!!
    List<String> friendsToAdd = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends_list);

        friendsToAdd.add("Viki");
        friendsToAdd.add("Thaarukan");
        friendsToAdd.add("Adhithi");
        friendsToAdd.add("Dyuti");
        friendsToAdd.add("Alex");

        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, friendsToAdd);

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
            removeFromList(selectedFriend);

            myGroupsIntent.putExtra("Selected", selectedFriend);
            myGroupsIntent.putExtra("Setter", setBubble);
            startActivity(myGroupsIntent);

        });
    }

    private void removeFromList(String friendAlreadyAdded) {
        friendsToAdd.remove(friendAlreadyAdded);
    }

}
