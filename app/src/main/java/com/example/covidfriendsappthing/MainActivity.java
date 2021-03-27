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

        Button settings = (Button) findViewById(R.id.covid_settings);

        //add the onClick listener
        settings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent isolatingIntent = new Intent(MainActivity.this, CovidSettingsActivity.class);

                startActivity(isolatingIntent);
            }
        });
    }
}