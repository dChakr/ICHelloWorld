package com.example.covidfriendsappthing;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AddFriend extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_friend);

        EditText addFriendField = findViewById(R.id.addFriendField);
        Button addFriendButton = findViewById(R.id.addFriendButton);

        addFriendButton.setOnClickListener(x -> {
            String toAdd = addFriendField.getText().toString();

            FirebaseAuth auth = FirebaseAuth.getInstance();
            DatabaseReference database = FirebaseDatabase.getInstance("https://pandemicpals-f29e4-default-rtdb.europe-west1.firebasedatabase.app/").getReference();

            String uid  = auth.getUid();
            database.child("Users").child(uid).get().addOnSuccessListener(dataSnapshot -> {
                User user = dataSnapshot.getValue(User.class);

                System.out.println(user.username + " first");

                database.child("Users").get().addOnSuccessListener(dataSnapshot1 -> {
                    for (DataSnapshot ds: dataSnapshot1.getChildren()) {
                        User user1  = ds.getValue(User.class);
                        if(user1.username.equals(toAdd)){

                            System.out.println(user1.username + " seconds");

                            if(user1.friends == null){
                                user1.friends = new ArrayList<>();
                            }
                            if(user.friends == null){
                                user.friends = new ArrayList<>();
                            }
                            user1.friends.add(uid);
                            user.friends.add(ds.getKey());
                            database.child("Users").child(uid).child("friends").setValue(user.friends);
                            database.child("Users").child(ds.getKey()).child("friends").setValue(user1.friends);
                        }
                    }
                });

            });


            Intent myGroupsIntent = new Intent(AddFriend.this, MainActivity.class);
            startActivity(myGroupsIntent);
        });


    }
}
