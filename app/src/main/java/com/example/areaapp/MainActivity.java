package com.example.areaapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static class Circle {
        private double radius;

        private void setRadius(double r) {
            radius = r;
        }

        public double calculateArea() {
            return Math.PI * radius * radius;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextRadius = findViewById(R.id.edittext_radius);
        Button buttonSubmit = findViewById(R.id.button_submit);

        buttonSubmit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        try {
            EditText editTextRadius = findViewById(R.id.edittext_radius);
            double radius = Double.parseDouble(editTextRadius.getText().toString());

            Circle circle = new Circle();
            circle.setRadius(radius);
            double area = circle.calculateArea();
            displayAreaDialogMessage(area);

        } catch (Exception e) {
            DialogMessage();
        }
    }

    private void DialogMessage() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("oups! Enter radius")
                .setTitle("Alert Message");

        builder.setPositiveButton(android.R.string.ok, (dialog, id) -> {

        });
        builder.setNegativeButton(android.R.string.cancel, (dialog, id) -> {

        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void displayAreaDialogMessage(double area) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("The area is " + area + " meter squared")
                .setTitle("Area Calculated");

        builder.setPositiveButton(android.R.string.ok, (dialog, id) -> {

        });
        builder.setNegativeButton(android.R.string.cancel, (dialog, id) -> {

        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
