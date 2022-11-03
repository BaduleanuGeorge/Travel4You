package com.example.travel4you;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EnglandLocationsActivity extends AppCompatActivity {

    private TextView ukDescription, healthDescription;

    public static ArrayList<Location> locationsList = new ArrayList<>();

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_england_locations);

        ukDescription = (TextView) findViewById(R.id.ukDescription);
        healthDescription = (TextView) findViewById(R.id.healthDescription);

        setupData();
        setupList();
        setupOnClickListener();

        // Text content of the Locations page
        String ukIntro = "<p> United Kingdom is an island country located off the northwestern coast of mainland Europe," +
                "and it contains four countries: <b> England, Wales, Scotland, and Northern Ireland. </b></p>";

        String healthIntro = "<p>Check the dangerous areas or hazards by pressing the <b>'Secure journey'</b> " +
                "button to find more.</p>";

        ukDescription.setText(Html.fromHtml(ukIntro));
        healthDescription.setText(Html.fromHtml(healthIntro));
    }

    private void setupData(){
        Location london = new Location("london", "London", R.drawable.uk_image);
        locationsList.add(london);

        Location edinburgh = new Location("edinburgh", "Edinburgh", R.drawable.edinburgh);
        locationsList.add(edinburgh);

        Location stonehenge = new Location("stonehenge", "Ancient Stonehenge and Medieval Salisbury", R.drawable.stonehenge);
        locationsList.add(stonehenge);

        Location royalwindsor = new Location("royalwindsor", "Royal Windsor", R.drawable.royalwindsor);
        locationsList.add(royalwindsor);

        Location lochness = new Location("lochness", "Loch Ness and Inverness", R.drawable.lochness);
        locationsList.add(lochness);
    }

    private void setupList(){
        listView = (ListView) findViewById(R.id.locationsListView);

        LocationAdapter adapter = new LocationAdapter(getApplicationContext(), 0, locationsList);
        listView.setAdapter(adapter);
    }

    private void setupOnClickListener(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position == 0){
                    startActivity(new Intent(EnglandLocationsActivity.this, LondonLocationActivity.class));
                } else{
                    Toast.makeText(EnglandLocationsActivity.this, "Not a valid option", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}