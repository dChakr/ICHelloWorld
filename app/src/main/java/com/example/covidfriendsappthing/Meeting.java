package com.example.covidfriendsappthing;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Meeting {

    public String meetingId;
    public String meetingName;
    public CovidStatus status;
    public ArrayList<String> members;

    public Meeting() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Meeting(String meetingId, String meetingName, User owner, ArrayList<String> members) {
        this.meetingId = meetingId;
        this.meetingName = meetingName;
        DatabaseReference database = FirebaseDatabase.getInstance("https://pandemicpals-f29e4-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        for (String member : members) {
            database.child("Users").get().addOnSuccessListener(dataSnapshot -> {
                boolean tempStatus = true;
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    User thisUser = ds.getValue(User.class);
                    if (thisUser.username.equals(member)) {
                        if (thisUser.status == CovidStatus.COVID_POSITIVE || thisUser.status == CovidStatus.CONTACT_WITH_COVID) {
                            tempStatus = false;
                        }
                    }
                }
                if (tempStatus) {
                    this.status = CovidStatus.COVID_NEGATIVE;
                } else {
                    this.status = CovidStatus.CONTACT_WITH_COVID;
                }
            });
        }
        this.members = members;
    }
}
