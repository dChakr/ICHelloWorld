package com.example.covidfriendsappthing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CreateGroupClass extends AppCompatActivity {

    static String bubble1;
    static String bubble2;
    static String bubble3;
    static String bubble4;
    static String bubble5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_group);

        Intent myGroupsIntent = new Intent(CreateGroupClass.this, FriendsClass.class);

        ImageButton person1 = findViewById(R.id.Person1);
        ImageButton person2 = findViewById(R.id.Person2);
        ImageButton person3 = findViewById(R.id.Person3);
        ImageButton person4 = findViewById(R.id.Person4);
        ImageButton person5 = findViewById(R.id.Person5);

        person1.setOnClickListener(view -> {
            myGroupsIntent.putExtra("Setter", person1.getId());

            startActivity(myGroupsIntent);
        });


        person2.setOnClickListener(view -> {
            myGroupsIntent.putExtra("Setter", person2.getId());

            startActivity(myGroupsIntent);
        });


        person3.setOnClickListener(view -> {
            myGroupsIntent.putExtra("Setter", person3.getId());

            startActivity(myGroupsIntent);
        });


        person4.setOnClickListener(view -> {
            myGroupsIntent.putExtra("Setter", person4.getId());

            startActivity(myGroupsIntent);
        });


        person5.setOnClickListener(view -> {
            myGroupsIntent.putExtra("Setter", person5.getId());

            startActivity(myGroupsIntent);
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String selFr = extras.getString("Selected");

            int setBubble = extras.getInt("Setter");
            if (setBubble == person1.getId()) {
                bubble1 = selFr;
            }
            if (setBubble == person2.getId()) {
                bubble2 = selFr;
            }
            if (setBubble == person3.getId()) {
                bubble3 = selFr;
            }
            if (setBubble == person4.getId()) {
                bubble4 = selFr;
            }
            if (setBubble == person5.getId()) {
                bubble5 = selFr;
            }
        }

        if (bubble1 != null) {
            person1.setVisibility(View.INVISIBLE);
            ((TextView) (findViewById(R.id.person1_name))).setText(bubble1);

        }
        if (bubble2 != null) {
            person2.setVisibility(View.INVISIBLE);
            ((TextView) (findViewById(R.id.person2_name))).setText(bubble2);
        }
        if (bubble3 != null) {
            person3.setVisibility(View.INVISIBLE);
            ((TextView) (findViewById(R.id.person3_name))).setText(bubble3);
        }
        if (bubble4 != null) {
            person4.setVisibility(View.INVISIBLE);
            ((TextView) (findViewById(R.id.person4_name))).setText(bubble4);
        }
        if (bubble5 != null) {
            person5.setVisibility(View.INVISIBLE);
            ((TextView) (findViewById(R.id.person5_name))).setText(bubble5);
        }


    }


    private void changeUserCovidStatus(ImageButton person) {
        //get covid status of the person from database
        CovidStatus status = getCovidStatus(person);

        switch(status) {
            case COVID_POSITIVE:
                person.setImageResource(R.drawable.covid_positive);
                break;
            case CONTACT_WITH_COVID:
                person.setImageResource(R.drawable.contact_covid);
                break;
            default:
                person.setImageResource(R.drawable.covid_free);
        }
    }

    private CovidStatus getCovidStatus(ImageButton person) {
        return CovidStatus.COVID_NEGATIVE;
    }

}
