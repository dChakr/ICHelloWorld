package com.example.covidfriendsappthing;

import java.util.ArrayList;

public class Meeting {

    public String meetingId;
    public String meetingName;
    public String status;
    public ArrayList<User> members;

    public Meeting() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Meeting(String meetingId, String meetingName, User owner) {
        this.meetingId = meetingId;
        this.meetingName = meetingName;
        this.status = owner.status;
        this.members = new ArrayList<>();
        this.members.add(owner);
    }

}
