package com.example.covidfriendsappthing;

import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CovidSettingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.covid_settings);

        RadioButton noSymp = findViewById(R.id.radioButton);
        RadioButton isolating = findViewById(R.id.radioButton2);
        RadioButton hasCovid = findViewById(R.id.radioButton3);
        Button confirmStatus = findViewById(R.id.confirmStatus);

        // PLACEHOLDER for my user and my contact list of the past 2 weeks
        User myself = new User();
        List<String> metTwoWeeks = new ArrayList<String>();

        confirmStatus.setOnClickListener(x -> {
            if (noSymp.isChecked()) {
                // either COVID_NEGATIVE or CONTACT_WITH_COVID

                // checks all people met in the last two weeks -> if any of them is positive, it is a contact.
                for (String person : metTwoWeeks) {
                    // if (person.status == CovidStatus.COVID_POSITIVE) {
                    // myself.status = CovidStatus.CONTACT_WITH_COVID;
                    // break;
                    // }
                }
                myself.status = CovidStatus.COVID_NEGATIVE;
            }
            else if (isolating.isChecked()) {
                myself.status = CovidStatus.CONTACT_WITH_COVID;
            }
            else if (hasCovid.isChecked()) {
                myself.status = CovidStatus.COVID_POSITIVE;
            }
        });


    }
}
