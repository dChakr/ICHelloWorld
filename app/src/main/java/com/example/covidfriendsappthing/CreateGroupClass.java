package com.example.covidfriendsappthing;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateGroupClass extends AppCompatActivity {

    static String user1;
    static String user2;
    static String user3;
    static String user4;
    static String user5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_group);

        ImageButton person1 = findViewById(R.id.Person1);
        ImageButton person2 = findViewById(R.id.Person2);
        ImageButton person3 = findViewById(R.id.Person3);
        ImageButton person4 = findViewById(R.id.Person4);
        ImageButton person5 = findViewById(R.id.Person5);

        Intent myGroupsIntent = new Intent(CreateGroupClass.this, FriendsClass.class);

        EditText meetingNameField = findViewById(R.id.reg_username);
        String meetingName = "new meeting";//meetingNameField.getText().toString();

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
                user1 = selFr;
            }
            if (setBubble == person2.getId()) {
                user2 = selFr;
            }
            if (setBubble == person3.getId()) {
                user3 = selFr;
            }
            if (setBubble == person4.getId()) {
                user4 = selFr;
            }
            if (setBubble == person5.getId()) {
                user5 = selFr;
            }
        }



        DatabaseReference database = FirebaseDatabase .getInstance("https://pandemicpals-f29e4-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        if (user1 != null) {

            database.child("Users").get().addOnSuccessListener(dataSnapshot -> {
                for (DataSnapshot ds:dataSnapshot.getChildren()) {
                    String UID = ds.child("username").getValue(String.class);
                    if (user1.equals(UID)){

                        CovidStatus status = ds.child("status").getValue(CovidStatus.class);

                        changeUserCovidStatus(person1, status);
                        ((TextView) (findViewById(R.id.person1_name))).setText(user1);
                        break;
                    }
                }
            });

        }
        if (user2 != null) {
            database.child("Users").get().addOnSuccessListener(dataSnapshot -> {
                for (DataSnapshot ds:dataSnapshot.getChildren()) {
                    String UID = ds.child("username").getValue(String.class);
                    if (user2.equals(UID)){

                        CovidStatus status = ds.child("status").getValue(CovidStatus.class);


                        changeUserCovidStatus(person2, status);
                        ((TextView) (findViewById(R.id.person2_name))).setText(user2);
                        break;
                    }
                }
            });

        }
        if (user3 != null) {
            database.child("Users").get().addOnSuccessListener(dataSnapshot -> {
                for (DataSnapshot ds:dataSnapshot.getChildren()) {
                    String UID = ds.child("username").getValue(String.class);
                    if (user3.equals(UID)){

                        CovidStatus status = ds.child("status").getValue(CovidStatus.class);


                        changeUserCovidStatus(person3, status);
                        ((TextView) (findViewById(R.id.person3_name))).setText(user3);
                        break;
                    }
                }
            });

        }
        if (user4 != null) {
            database.child("Users").get().addOnSuccessListener(dataSnapshot -> {
                for (DataSnapshot ds:dataSnapshot.getChildren()) {
                    String UID = ds.child("username").getValue(String.class);
                    if (user4.equals(UID)){

                        CovidStatus status = ds.child("status").getValue(CovidStatus.class);

                        changeUserCovidStatus(person4, status);
                        ((TextView) (findViewById(R.id.person4_name))).setText(user4);
                        break;
                    }
                }
            });

        }
        if (user5 != null) {
            database.child("Users").get().addOnSuccessListener(dataSnapshot -> {
                for (DataSnapshot ds:dataSnapshot.getChildren()) {
                    String UID = ds.child("username").getValue(String.class);
                    if (user5.equals(UID)){

                        CovidStatus status = ds.child("status").getValue(CovidStatus.class);


                        changeUserCovidStatus(person5, status);
                        ((TextView) (findViewById(R.id.person5_name))).setText(user5);
                        break;
                    }
                }
            });

        }

        ((TextView) (findViewById(R.id.meeting_name))).setText(meetingName);

    }

    private void changeUserCovidStatus(ImageButton person, CovidStatus status) {
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


}