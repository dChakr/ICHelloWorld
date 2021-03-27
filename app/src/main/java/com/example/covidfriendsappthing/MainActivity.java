package com.example.covidfriendsappthing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button settings = (Button) findViewById(R.id.settings_button);

        //add the onClick listener
        settings.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view){
                Intent settingsIntent = new Intent(MainActivity.this, CovidSettingsActivity.class);

                startActivity(settingsIntent);
            }
        });

        Button newGroup = (Button) findViewById(R.id.group_button);

        newGroup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newGroupIntent = new Intent(MainActivity.this, CreateGroupClass.class);

                startActivity(newGroupIntent);
            }
        });

        Button myGroups = (Button) findViewById(R.id.my_groups_button);

        myGroups.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myGroupsIntent = new Intent(MainActivity.this, MyGroupsClass.class);

                startActivity(myGroupsIntent);
            }
        });
    }
}