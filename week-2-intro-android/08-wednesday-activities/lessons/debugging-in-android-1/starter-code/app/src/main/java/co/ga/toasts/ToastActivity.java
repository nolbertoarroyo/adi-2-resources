package co.ga.toasts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {
    Button buyButton;
    Button saveButton;
    Button sendButton;
    Button likeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        buyButton = (Button)findViewById(R.id.buyButton);
        saveButton = (Button)findViewById(R.id.saveButton);
        sendButton = (Button)findViewById(R.id.sendButton);
        likeButton = (Button)findViewById(R.id.likeButton);

        View.OnClickListener buyListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToastActivity.this,"Buy button is pressed", Toast.LENGTH_SHORT).show();
            }
        };
            buyButton.setOnClickListener(buyListener);

        View.OnClickListener saveListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToastActivity.this,"Save button is pressed", Toast.LENGTH_SHORT).show();
            }
        };

            saveButton.setOnClickListener(saveListener);

        View.OnClickListener sendListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToastActivity.this,"Send button is pressed", Toast.LENGTH_SHORT).show();
            }
        };
            sendButton.setOnClickListener(sendListener);

        View.OnClickListener likeListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToastActivity.this,"LIke button is pressed", Toast.LENGTH_SHORT).show();
                Log.v("ToastActivity", "LIKE BUTTON WAS CLICKED");
            }
        };
        likeButton.setOnClickListener(likeListener);
    }


}
