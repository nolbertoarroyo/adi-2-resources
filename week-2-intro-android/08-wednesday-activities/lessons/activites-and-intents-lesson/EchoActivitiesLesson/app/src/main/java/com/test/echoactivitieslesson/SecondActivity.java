package com.test.echoactivitieslesson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView resultText = (TextView) findViewById(R.id.textView1);

        Intent result = getIntent();
        int res=result.getIntExtra("result",-1);
        resultText.setText("the sum is " + res);

    }
}
