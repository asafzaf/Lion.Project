package com.prod.lionsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.sql.SQLData;

public class ProjectsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects_screen);

        Button AddProject = new Button(this);
        AddProject = findViewById(R.id.idRVaddproject);

        Spinner seeProjects = new Spinner(this);
        seeProjects = findViewById(R.id.see_project_spinner);

        

        AddProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProjectsScreen.this, AddScreenPROJECT.class));
            }
        });
    }
}