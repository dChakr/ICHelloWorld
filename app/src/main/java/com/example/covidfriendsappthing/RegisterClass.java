package com.example.covidfriendsappthing;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterClass extends AppCompatActivity {

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);
        Button registerButton = findViewById(R.id.settings_button);

        EditText regUsernameField = findViewById(R.id.reg_username);
        EditText regPasswordField = findViewById(R.id.user_password);
        EditText regEmailField = findViewById(R.id.user_email);
        EditText phoneNumField = findViewById(R.id.phone_number);

        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            System.out.println("User in here");
            finish();
        }

        registerButton.setOnClickListener(x -> {

            boolean valid = true;

            String regPassword = regPasswordField.getText().toString().trim();
            String regUsername = regUsernameField.getText().toString().trim();
            String regPhoneNum = phoneNumField.getText().toString().trim();
            String regEmail = regEmailField.getText().toString().trim();
            if(regPassword.isEmpty()) valid =false;
            if(regPassword.length() < 6){
                valid =false;
                Toast.makeText(RegisterClass.this, "Password must be at least 6 chars", Toast.LENGTH_SHORT).show();
            }
            if(regUsername.isEmpty()) valid =false;
            if(regPhoneNum.isEmpty()) valid =false;
            if(regEmail.isEmpty()) valid =false;


            if(valid){
                auth.createUserWithEmailAndPassword(regEmail, regPassword).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        writeNewUser(auth.getCurrentUser().getUid(), regUsername, regEmail, regPhoneNum);
                        Toast.makeText(RegisterClass.this, "User created.",
                                Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    } else {
                        Toast.makeText(RegisterClass.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }else{
                Toast.makeText(RegisterClass.this, "Please enter all of the fields", Toast.LENGTH_SHORT).show();
            }



        });
    }


    public void writeNewUser(String userId, String name, String email, String phoneNumber) {
        DatabaseReference mDatabase = FirebaseDatabase.getInstance("https://pandemicpals-f29e4-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        User user = new User(name, email, phoneNumber);

        mDatabase.child("Users").child(userId).setValue(user);
    }

}
