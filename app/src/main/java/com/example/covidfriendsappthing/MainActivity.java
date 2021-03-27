package com.example.covidfriendsappthing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button settings = findViewById(R.id.covid_settings);

        System.out.println(settings);

        //add the onClick listener
        settings.setOnClickListener(view -> {
            Intent isolatingIntent = new Intent(MainActivity.this, CovidSettingsActivity.class);

            startActivity(isolatingIntent);
        });

        Button newGroup = findViewById(R.id.create_groups);

        newGroup.setOnClickListener(v -> {
            Intent isolatingIntent1 = new Intent(MainActivity.this, CreateGroupClass.class);

            startActivity(isolatingIntent1);
        });

        Button myGroups = findViewById(R.id.my_groups);

        myGroups.setOnClickListener(v -> {
            Intent isolatingIntent2 = new Intent(MainActivity.this, MyGroupsClass.class);

            startActivity(isolatingIntent2);
        });
    }
}