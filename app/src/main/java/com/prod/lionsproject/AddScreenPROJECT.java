package com.prod.lionsproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.viewmodel.CreationExtras;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class AddScreenPROJECT extends AppCompatActivity {
    private static final int NULL = -1;
    private EditText name_project, start_date, name_machon, num_contract, name_costumer, phone_costumer, email_costumer;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_screen_project);

        Button enter_button = new Button(this);
        enter_button = findViewById(R.id.button_NEW_PROJECT_DONE);

        Button back_button = new Button(this);
        back_button = findViewById(R.id.button_NEW_PROJECT_BACK);

        name_project = findViewById(R.id.PROJECT_NEW_NAME_OF_PROJECT);
        start_date = findViewById(R.id.PROJECT_NEW_DATE_OF_START);
        name_machon = findViewById(R.id.PROJECT_NEW_NAME_OF_MACHON);
        num_contract = findViewById(R.id.PROJECT_NEW_NUM_OF_CONTRACT);
        name_costumer = findViewById(R.id.PROJECT_NEW_NAME_OF_COSTUMER);
        phone_costumer = findViewById(R.id.PROJECT_NEW_NUM_PHONE_COSTUMER);
        email_costumer = findViewById((R.id.PROJECT_NEW_EMAIL_COSTUMER));

        dbHandler = new DBHandler(AddScreenPROJECT.this);

        enter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Name_proj = name_project.getText().toString();
                String Start_date = start_date.getText().toString();
                String Name_machon = name_machon.getText().toString();
                String Num_contract = num_contract.getText().toString();
                String Name_costumer = name_costumer.getText().toString();
                String Phone_costumer = phone_costumer.getText().toString();
                String Email_costumer = email_costumer.getText().toString();

                dbHandler.addNewProject(Name_proj, Start_date, Name_machon, Num_contract, Name_costumer, Phone_costumer, Email_costumer);

                Toast.makeText(AddScreenPROJECT.this, "activity has been added.", Toast.LENGTH_SHORT).show();
                name_project.setText("");
                start_date.setText("");
                name_machon.setText("");
                num_contract.setText("");
                name_costumer.setText("");
                phone_costumer.setText("");
                email_costumer.setText("");

                startActivity(new Intent(AddScreenPROJECT.this, MainScreen.class));
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddScreenPROJECT.this, MainScreen.class));
            }
        });
    }
}