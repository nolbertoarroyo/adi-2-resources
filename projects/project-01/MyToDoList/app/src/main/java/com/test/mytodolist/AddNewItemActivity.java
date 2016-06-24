package com.test.mytodolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewItemActivity extends AppCompatActivity {
    Button createButton;
    EditText itemName, itemDescription;
    protected static String newItemName = "newItemName";
    protected static String newItemDescription = "newItemDescription";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_item);

        Intent recievedIntent = getIntent();
        createButton = (Button) findViewById(R.id.create_item_button);
        itemName = (EditText) findViewById(R.id.item_name);
        itemDescription = (EditText) findViewById(R.id.item_description);
        createButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String name = itemName.getText().toString();
                String description = itemDescription.getText().toString();
                if (name.isEmpty() && description.isEmpty()) {
                    Toast.makeText(AddNewItemActivity.this, "Please Fill Out", Toast.LENGTH_LONG).show();
                } else if (name.isEmpty()) {
                    Toast.makeText(AddNewItemActivity.this, "Please Fill Out Name", Toast.LENGTH_LONG).show();

                } else {
                    Intent intent = new Intent();
                    intent.putExtra(newItemName, name);
                    intent.putExtra(newItemDescription, description);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });


    }
}