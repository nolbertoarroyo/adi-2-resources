package com.test.echostartactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    Button returnButton;
    EditText num1;
    EditText num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        returnButton = (Button)findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 =(EditText)findViewById(R.id.text1);
                num2 =(EditText)findViewById(R.id.text2);
                int numOne = Integer.parseInt(num1.getText().toString());
                int numTwo = Integer.parseInt(num2.getText().toString());
                Intent intent= new Intent();
                intent.putExtra("num1", numOne);
                intent.putExtra("num2", numTwo);
                setResult(RESULT_OK,intent);
                finish();

            }
        });


    }
}
