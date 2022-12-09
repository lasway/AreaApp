package com.example.areaapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.*;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextRadius = findViewById(R.id.edittext_radius);
        Button buttonSubmit = findViewById(R.id.button_submit);

        buttonSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        EditText editTextRadius = findViewById(R.id.edittext_radius);
        double radius = Double.parseDouble(editTextRadius.getText().toString());

        Circle circle = new Circle();
        circle.setRadius(radius);
        double area = circle.calculateArea();
        displayAreaDialogMessage(area);


    }
    private void displayAreaDialogMessage(double area){


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("The area is "+ area +" meter squared")
                .setTitle("Area Calculated");

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }






    public class Circle {
        private double radius;

        private void setRadius(double r)
        {
            radius = r;
        }

        public double calculateArea()
        {
            return Math.PI * radius * radius;
        }
    }
}