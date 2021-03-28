package com.example.covidfriendsappthing;

import java.util.ArrayList;
import java.util.List;

public class User {

    public String username;
    public String email;
    public String phoneNumber;
    public CovidStatus status;
    public ArrayList<String> friends;
    public ArrayList<Meeting> meetings;
    public List<String> metTwoWeeks;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = CovidStatus.EMPTY;
        this.friends = new ArrayList<>();
        this.meetings = new ArrayList<>();
        this.metTwoWeeks = new ArrayList<>();

    }
}
