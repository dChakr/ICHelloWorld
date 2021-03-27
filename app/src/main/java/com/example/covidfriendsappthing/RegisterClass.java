package com.example.covidfriendsappthing;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterClass extends AppCompatActivity {

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);
        Button registerButton = findViewById(R.id.settings_button);
        registerButton.setOnClickListener(x -> {
            EditText regUsernameField = findViewById(R.id.reg_username);
            String regUsername = regUsernameField.getText().toString();

            EditText regPasswordField = findViewById(R.id.user_password);
            String regPassword = regPasswordField.getText().toString();

            EditText regEmailField = findViewById(R.id.user_email);
            String regEmail = regEmailField.getText().toString();

            EditText phoneNumField = findViewById(R.id.phone_number);
            String phoneNum = phoneNumField.getText().toString();

            mDatabase = FirebaseDatabase.getInstance("https://pandemicpals-f29e4-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
            writeNewUser(regEmail, regUsername, regEmail, phoneNum, regPassword);

        });
    }


    public void writeNewUser(String userId, String name, String email, String phoneNumber, String password) {
        User user = new User(name, email, phoneNumber, password);

        mDatabase.child("Users").child(userId).setValue(user);
    }

}
