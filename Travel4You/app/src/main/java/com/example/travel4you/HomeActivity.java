package com.example.travel4you;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView addNote, travel, converter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        addNote = findViewById(R.id.noteIcon);
        addNote.setOnClickListener(this);

        travel = findViewById(R.id.travelIcon);
        travel.setOnClickListener(this);

        converter = findViewById(R.id.currencyIcon);
        converter.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.noteIcon:
                startActivity(new Intent(this, NoteTakingActivity.class));
                break;
            case R.id.travelIcon:
                startActivity(new Intent(this, CountriesActivity.class));

                break;
            case R.id.currencyIcon:
                startActivity(new Intent(this, CurrencyConverterActivity.class));
                break;
        }
    }
}