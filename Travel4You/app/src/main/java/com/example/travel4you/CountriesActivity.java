package com.example.travel4you;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class CountriesActivity extends AppCompatActivity {

    public static ArrayList<Country> countryList = new ArrayList<>();

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        initSearchBar();

        setupData();
        setupList();
        setupOnClickListener();
    }

    public void initSearchBar(){
        SearchView searchView = (SearchView) findViewById(R.id.countrySearchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<Country> filteredCountries = new ArrayList<>();

                for(Country country: countryList){
                    if(country.getName().toLowerCase().contains(s.toLowerCase())){
                        filteredCountries.add(country);
                    }
                }

                CountryAdapter countryAdapter = new CountryAdapter(getApplicationContext(), 0, filteredCountries);
                listView.setAdapter(countryAdapter);
                return false;
            }
        });
    }


    private void setupData(){
        Country uk = new Country("uk", "United Kingdom", R.drawable.uk_image);
        countryList.add(uk);

        Country france = new Country("france", "France", R.drawable.france_image);
        countryList.add(france);

        Country germany = new Country("germany", "Germany", R.drawable.germany_image);
        countryList.add(germany);

        Country spain = new Country("spain", "Spain", R.drawable.spain_image);
        countryList.add(spain);
    }

    private void setupList(){
        listView = (ListView) findViewById(R.id.countriesListView);

        CountryAdapter adapter = new CountryAdapter(getApplicationContext(), 0, countryList);
        listView.setAdapter(adapter);
    }

    private void setupOnClickListener(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position == 0){
                    startActivity(new Intent(CountriesActivity.this, EnglandLocationsActivity.class));
                } else{
                    Toast.makeText(CountriesActivity.this, "Not a valid option", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}