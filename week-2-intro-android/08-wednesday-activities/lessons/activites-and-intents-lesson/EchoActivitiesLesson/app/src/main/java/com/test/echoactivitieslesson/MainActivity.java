package com.test.echoactivitieslesson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button1;
    EditText firstNum;
    EditText secondNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1= (Button)findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                firstNum = (EditText)findViewById(R.id.editText1);
                secondNum = (EditText)findViewById(R.id.editText2);
                int num =Integer.parseInt(firstNum.getText().toString());
                int num2 =Integer.parseInt(secondNum.getText().toString());
                int sum = num + num2;
                Intent getSum = new Intent(MainActivity.this,SecondActivity.class);
                getSum.putExtra("result",sum);
                startActivity(getSum);


            }
        });


    }
}
