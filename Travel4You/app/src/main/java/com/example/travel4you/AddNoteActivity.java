package com.example.travel4you;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddNoteActivity extends AppCompatActivity {

    private EditText titleInput, descriptionInput;
    private Button saveNote;
    private DatabaseReference dbReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        titleInput = (EditText) findViewById(R.id.titleInput);
        descriptionInput = (EditText) findViewById(R.id.descriptionInput);
        dbReference = FirebaseDatabase.getInstance().getReference("Notes");

        saveNote = (Button) findViewById(R.id.saveNoteBttn);
        saveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = titleInput.getText().toString();
                String description = descriptionInput.getText().toString();
                long createdTime = System.currentTimeMillis();

                Note note = new Note(title, description, createdTime);
                dbReference.child(title).setValue(note);
                Toast.makeText(AddNoteActivity.this,
                        "Note saved!", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(AddNoteActivity.this, HomeActivity.class));
            }
        });
    }

    ;
}