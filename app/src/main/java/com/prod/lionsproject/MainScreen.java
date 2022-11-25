package com.prod.lionsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        Button AddVisit = new Button(this);
        AddVisit = findViewById(R.id.MainAddVisit);

        Button Projects = new Button(this);
        Projects = findViewById(R.id.MainProdButton);

        Button Contacts = new Button(this);
        Contacts = findViewById(R.id.MainContactButton);

        AddVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainScreen.this, AddScreenVISIT.class));
            }
        });

        Projects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainScreen.this, ProjectsScreen.class));
            }
        });

        Contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainScreen.this, ContactsScreen.class));
            }
        });
    }
}