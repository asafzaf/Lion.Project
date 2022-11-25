package com.prod.lionsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.prod.lionsproject.modals.ProjectsModal;

public class AddScreenVISIT extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {
    private static final int NULL = -1;
    private EditText Project_id, Date_full, Start_time, End_time, Imp1, Imp2, Imp3, Imp4;
    private Button done_button, back_button;
    private DBHandler dbHandler;
    private Spinner spinner_Project_id, spinner_Con1, spinner_Con2, spinner_Con3, spinner_Con4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_screen_visit);

        done_button = findViewById(R.id.button_VISIT_DONE);
        back_button = findViewById(R.id.button_VISIT_BACK);

        spinner_Project_id = findViewById(R.id.spinner_PROJECT);
        Date_full = findViewById(R.id.editTextDateVISIT);
        Start_time = findViewById(R.id.editTextTime_START);
        End_time = findViewById(R.id.editTextTime_END);

        Imp1 = findViewById(R.id.editTextTextMultiLine_LICUI1);
        spinner_Con1 = findViewById(R.id.spinner_CONTACT1);

        Imp2 = findViewById(R.id.editTextTextMultiLine_LICUI2);
        spinner_Con2 = findViewById(R.id.spinner_CONTACT2);

        Imp3 = findViewById(R.id.editTextTextMultiLine_LICUI3);
        spinner_Con3 = findViewById(R.id.spinner_CONTACT3);

        Imp4 = findViewById(R.id.editTextTextMultiLine_LICUI4);
        spinner_Con4 = findViewById(R.id.spinner_CONTACT4);

        dbHandler = new DBHandler(AddScreenVISIT.this);

        spinner_Project_id.setOnItemSelectedListener(this);
        spinner_Con1.setOnItemSelectedListener(this);
        spinner_Con2.setOnItemSelectedListener(this);
        spinner_Con3.setOnItemSelectedListener(this);
        spinner_Con4.setOnItemSelectedListener(this);


        done_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //בדיקה של כל הנתונים


                Toast.makeText(AddScreenVISIT.this, "visit has been added.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AddScreenVISIT.this, MainScreen.class));
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddScreenVISIT.this, MainScreen.class));
            }
        });

    }

    private void loadSpinnerProjectsData() {
        DBHandler db = new DBHandler(getApplicationContext());
        List<ProjectsModal> labels = db.readProjects_to_spinner();

        // Creating adapter for spinner
        ArrayAdapter<ProjectsModal> dataAdapter = new ArrayAdapter<ProjectsModal>(this, android.R.layout.simple_spinner_item, labels);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner_Project_id.setAdapter(dataAdapter);

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        // On selecting a spinner item
        String label = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + label,
                Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

}