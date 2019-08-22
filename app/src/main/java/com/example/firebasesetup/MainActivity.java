package com.example.firebasesetup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{
    private EditText name, fatherName, email, institute;
    private Button saveButton, readData;
    private FirestoreHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        onListener();
    }

    private void initialize(){
        name = findViewById(R.id.name);
        fatherName = findViewById(R.id.fatherName);
        email = findViewById(R.id.email);
        institute = findViewById(R.id.institute);
        saveButton = findViewById(R.id.saveButton);
        readData = findViewById(R.id.readData);

        handler = new FirestoreHandler();
    }

    private void onListener(){
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.insertData( new DataModel(name.getText().toString(),
                                                  fatherName.getText().toString(),
                                                  email.getText().toString(),
                                                  institute.getText().toString()));

                clearFields();
            }
        });

        readData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReadDataActivity.class);
                startActivity(intent);
           }
        });
    }

    private void clearFields(){
        name.setText("");
        fatherName.setText("");
        email.setText("");
        institute.setText("");
    }
}
