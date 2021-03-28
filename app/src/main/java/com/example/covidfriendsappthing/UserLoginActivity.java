package com.example.covidfriendsappthing;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

public class UserLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText usernameField = findViewById(R.id.username);
        EditText passwordField = findViewById(R.id.password);

        Button loginBtn = findViewById(R.id.signInButton);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameField.getText().toString();
                String password = passwordField.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(UserLoginActivity.this, "Please enter all of the fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (validateUserInputs(username, password)) {
                        Intent startUser = new Intent(UserLoginActivity.this, MainActivity.class);

                        startActivity(startUser);
                    } else {
                        Toast.makeText(UserLoginActivity.this, "Invalid user credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Button registerBtn = findViewById(R.id.registerButton);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(UserLoginActivity.this, RegisterClass.class);

                startActivity(register);
            }
        });
    }

    private boolean validateUserInputs(String username, String password) {
        return true;
    }
}
