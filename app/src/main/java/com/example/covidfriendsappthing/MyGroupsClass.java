package com.example.covidfriendsappthing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MyGroupsClass extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_groups);

        Button viewMembers = (Button) findViewById(R.id.view_members1);

        viewMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView meetingNameBox = findViewById(R.id.group_name1);
                String meetingName = meetingNameBox.getText().toString();

                Intent meeting = new Intent(MyGroupsClass.this, CreatedMeetingActivity2.class);

                meeting.putExtra("meetingName", meetingName);
                meeting.putExtra("member1", "Mum");
                meeting.putExtra("member2", "Dad");
                meeting.putExtra("member3", "Daniel");
                meeting.putExtra("member4", "Alice");
                meeting.putExtra("member5", "Tom");

                startActivity(meeting);
            }
        });

    }
}
