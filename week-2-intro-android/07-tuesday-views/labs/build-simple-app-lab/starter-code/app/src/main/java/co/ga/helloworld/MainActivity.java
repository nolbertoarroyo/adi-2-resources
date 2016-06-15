package co.ga.helloworld;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView colorText;
    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        colorText =  (TextView) findViewById(R.id.textView1);
        button1 = (Button) findViewById(R.id.buttonOne);
        button2 = (Button) findViewById(R.id.buttonTwo);
        button3 = (Button) findViewById(R.id.buttonThree);

        View.OnClickListener buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                colorText.setTextColor(Color.BLUE);
                button1.setTextColor(Color.BLUE);

            }

        };
            button1.setOnClickListener(buttonListener);


        View.OnClickListener buttonTwoListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                colorText.setTextColor(Color.GREEN);
                button2.setTextColor(Color.GREEN);


            }

        };
            button2.setOnClickListener(buttonTwoListener);

        View.OnClickListener buttonThreeListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                colorText.setTextColor(Color.RED);
                button3.setTextColor(Color.RED);


            }

        };
            button3.setOnClickListener(buttonThreeListener);


    }

}

