package com.example.covidfriendsappthing;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddFriend extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_friend);

        EditText addFriendField = findViewById(R.id.addFriendField);
        Button addFriendButton = findViewById(R.id.addFriendButton);

        addFriendButton.setOnClickListener(x -> {
            String toAdd = addFriendField.getText().toString();

            Intent myGroupsIntent = new Intent(AddFriend.this, MainActivity.class);
            startActivity(myGroupsIntent);
        });


    }
}
