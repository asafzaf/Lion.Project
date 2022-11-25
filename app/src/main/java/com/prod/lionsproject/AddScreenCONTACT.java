package com.prod.lionsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddScreenCONTACT extends AppCompatActivity {
    private static final int NULL = -1;
    private EditText contact_name, contact_profession, contact_phone, contact_mail;
    private DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_screen_contact);

        Button enter_button = new Button(this);
        enter_button = findViewById(R.id.button_NEW_CONTACT_DONE);

        Button back_button = new Button(this);
        back_button = findViewById(R.id.button_NEW_CONTACT_BACK);

        contact_name = findViewById(R.id.CONTACT_NEW_NAME_OF_CONTACT);
        contact_profession = findViewById(R.id.CONTACT_NEW_PROFESSION_OF_CONTACT);
        contact_phone = findViewById(R.id.CONTACT_NEW_NUM_PHONE_CONTACT);
        contact_mail = findViewById(R.id.CONTACT_NEW_EMAIL_CONTACT);

        dbHandler = new DBHandler(AddScreenCONTACT.this);

        enter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Contact_name = contact_name.getText().toString();
                String Contact_profession = contact_profession.getText().toString();
                String Contact_phone = contact_phone.getText().toString();
                String Contact_mail = contact_mail.getText().toString();

                dbHandler.addNewContact(Contact_name, Contact_profession, Contact_phone, Contact_mail);

                Toast.makeText(AddScreenCONTACT.this, "contact has been added.", Toast.LENGTH_SHORT).show();
                contact_name.setText("");
                contact_profession.setText("");
                contact_phone.setText("");
                contact_mail.setText("");

                startActivity(new Intent(AddScreenCONTACT.this, ViewContactPage.class));
            }
        });

        back_button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddScreenCONTACT.this, MainScreen.class));
            }
        }));

    }
}