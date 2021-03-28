package com.example.covidfriendsappthing;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CreatedMeetingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.curr_meeting);

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            String name = extra.getString("meetingName");
            ((TextView) (findViewById(R.id.new_meeting_name))).setText(name);

            String member1 = extra.getString("member1");
            ((TextView) (findViewById(R.id.member1))).setText(member1);

            String member2 = extra.getString("member2");
            ((TextView) (findViewById(R.id.member2))).setText(member2);

            String member3 = extra.getString("member3");
            ((TextView) (findViewById(R.id.member3))).setText(member3);
            String member4 = extra.getString("member4");
            ((TextView) (findViewById(R.id.member4))).setText(member4);
            String member5 = extra.getString("member5");
            ((TextView) (findViewById(R.id.member5))).setText(member5);
        }
    }
}
