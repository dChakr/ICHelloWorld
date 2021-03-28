package com.example.covidfriendsappthing;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class CovidSettingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.covid_settings);

        RadioButton noSymp = findViewById(R.id.radioButton);
        RadioButton isolating = findViewById(R.id.radioButton2);
        RadioButton hasCovid = findViewById(R.id.radioButton3);
        Button confirmStatus = findViewById(R.id.confirmStatus);

        FirebaseAuth auth = FirebaseAuth.getInstance();

        // PLACEHOLDER for my user and my contact list of the past 2 weeks

        String uid = auth.getUid();
        DatabaseReference database = FirebaseDatabase.getInstance("https://pandemicpals-f29e4-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        database.child("Users").child(uid).get().addOnSuccessListener(dataSnapshot -> {
            System.out.println(dataSnapshot);
            User myself = dataSnapshot.getValue(User.class);

            confirmStatus.setOnClickListener(x -> {
                if (noSymp.isChecked()) {
                    // either COVID_NEGATIVE or CONTACT_WITH_COVID
                    if (myself.metTwoWeeks == null){
                        database.child("Users").child(uid).child("status").setValue(CovidStatus.COVID_NEGATIVE);
                    } else {
                        for (String person : myself.metTwoWeeks) {
                            database.child("Users").child(person).get().addOnSuccessListener(dataSnapshot1 -> {
                                User other = dataSnapshot1.getValue(User.class);
                                if (other.status == CovidStatus.COVID_POSITIVE) {
                                    database.child("Users").child(uid).child("status").setValue(CovidStatus.CONTACT_WITH_COVID);
                                    //myself.status = CovidStatus.CONTACT_WITH_COVID;
                                }
                            });

                            if (myself.status == CovidStatus.CONTACT_WITH_COVID) {
                                break;
                            } else {
                                //myself.status = CovidStatus.COVID_NEGATIVE;
                                database.child("Users").child(uid).child("status").setValue(CovidStatus.COVID_NEGATIVE);
                            }
                            //TEST THIS

                        }
                    }
                    // checks all people met in the last two weeks -> if any of them is positive, it is a contact.

                } else if (isolating.isChecked()) {
                    //myself.status = CovidStatus.CONTACT_WITH_COVID;
                    database.child("Users").child(uid).child("status").setValue(CovidStatus.COVID_NEGATIVE);
                } else if (hasCovid.isChecked()) {
                    //myself.status = CovidStatus.COVID_POSITIVE;
                    if (myself.metTwoWeeks == null){
                        database.child("Users").child(uid).child("status").setValue(CovidStatus.COVID_POSITIVE);
                    } else {
                        for (String person : myself.metTwoWeeks) {
                            database.child("Users").child(person).get().addOnSuccessListener(dataSnapshot1 -> {
                                User other = dataSnapshot1.getValue(User.class);
                                if (other.status != CovidStatus.COVID_POSITIVE) {
                                    database.child("Users").child(person).child("status").setValue(CovidStatus.CONTACT_WITH_COVID);
                                }
                            });
                        }
                    }
                }

                Intent myGroupsIntent = new Intent(CovidSettingsActivity.this, MainActivity.class);
                startActivity(myGroupsIntent);

            });
        });


    }
}
