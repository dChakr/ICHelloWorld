package com.example.covidfriendsappthing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class CreateGroupClass extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_group);

        ImageButton person1 = findViewById(R.id.Person1);
        person1.setOnClickListener(view -> {
            Intent myGroupsIntent = new Intent(CreateGroupClass.this, FriendsClass.class);

            startActivity(myGroupsIntent);
        });

        ImageButton person2 = findViewById(R.id.Person2);
        person2.setOnClickListener(view -> {
            Intent myGroupsIntent = new Intent(CreateGroupClass.this, FriendsClass.class);

            startActivity(myGroupsIntent);
        });

        ImageButton person3 = findViewById(R.id.Person3);
        person3.setOnClickListener(view -> {
            Intent myGroupsIntent = new Intent(CreateGroupClass.this, FriendsClass.class);

            startActivity(myGroupsIntent);
        });

        ImageButton person4 = findViewById(R.id.Person4);
        person4.setOnClickListener(view -> {
            Intent myGroupsIntent = new Intent(CreateGroupClass.this, FriendsClass.class);

            startActivity(myGroupsIntent);
        });

        ImageButton person5 = findViewById(R.id.Person5);
        person5.setOnClickListener(view -> {
            Intent myGroupsIntent = new Intent(CreateGroupClass.this, FriendsClass.class);

            startActivity(myGroupsIntent);
        });
    }

}
