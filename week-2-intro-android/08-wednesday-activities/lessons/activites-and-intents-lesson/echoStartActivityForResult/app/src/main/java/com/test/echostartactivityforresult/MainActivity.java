package com.test.echostartactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button addButton;
    Button subtractButton;
    TextView result;
    private static final int ADD_REQUEST = 7;
    private static final int SUB_REQUEST = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        result = (TextView) findViewById(R.id.resultView);
        addButton = (Button) findViewById(R.id.addButton);
        subtractButton = (Button) findViewById(R.id.subtractButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(addIntent, ADD_REQUEST);

            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent subIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(subIntent, SUB_REQUEST);
            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check what request we're responding to...
        if (requestCode == ADD_REQUEST) {
            // Make sure the request was successful...
            if (resultCode == RESULT_OK) {
                int numberOne = data.getIntExtra("num1", -1);
                int numberTwo = data.getIntExtra("num2", -1);
                int addResult = numberOne + numberTwo;
                result.setText(addResult + "");

            }
        }
        if (requestCode == SUB_REQUEST) {
            // Make sure the request was successful...
            if (resultCode == RESULT_OK) {
                int numberOne = data.getIntExtra("num1", -1);
                int numberTwo = data.getIntExtra("num2", -1);
                int subResult = numberOne - numberTwo;
                result.setText(subResult + "");

            }
        }
    }
}




