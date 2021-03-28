package com.example.covidfriendsappthing;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class FriendsClass extends AppCompatActivity {

    List<String> friends = new ArrayList<>();
    FirebaseAuth auth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends_list);



        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<String>(FriendsClass.this, android.R.layout.simple_list_item_1, friends);
        ListView listView = (ListView) findViewById(R.id.friendlist);

        String uid = auth.getUid();
        DatabaseReference database = FirebaseDatabase.getInstance("https://pandemicpals-f29e4-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        database.child("Users").child(uid).child("friends").get().addOnSuccessListener(dataSnapshot -> {
            for (DataSnapshot ds:dataSnapshot.getChildren()) {
                String u = ds.getValue(String.class);

                database.child("Users").child(u).get().addOnSuccessListener(dataSnapshot1 -> {
                    User p = dataSnapshot1.getValue(User.class);
                    arrayAdapter.add(p.username);
                });


            }
            arrayAdapter.notifyDataSetChanged();
        });

/*
        friends.add("Viki");
        friends.add("Thaarukan");
        friends.add("Adhithi");
        friends.add("Dyuti");
        friends.add("Alex");
*/


        listView.setAdapter(arrayAdapter);

        Intent myGroupsIntent = new Intent(FriendsClass.this, CreateGroupClass.class);

        listView.setOnItemClickListener((parent, view, position, id) -> {

            int setBubble = -1;

            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                setBubble = extras.getInt("Setter");
            }

            String selectedFriend = listView.getItemAtPosition(position).toString();

            myGroupsIntent.putExtra("Selected", selectedFriend);
            myGroupsIntent.putExtra("Setter", setBubble);
            startActivity(myGroupsIntent);

        });
    }
}
