package com.test.mytodolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewListActivity extends AppCompatActivity {

    Button createButton;
    EditText listName, listDescription;
    protected static String newListName = "newListName";
    protected static String newListDescription = "newListDescription";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_list);

        Intent recievedIntent = getIntent();
        createButton = (Button) findViewById(R.id.create_list_button);
        listName = (EditText) findViewById(R.id.list_name);
        listDescription = (EditText) findViewById(R.id.list_description);
        createButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String name = listName.getText().toString();
                String description = listDescription.getText().toString();

                if (name.isEmpty() && description.isEmpty()) {
                    Toast.makeText(AddNewListActivity.this, "Please Fill Out", Toast.LENGTH_LONG).show();
                } else if (description.isEmpty()) {
                    Toast.makeText(AddNewListActivity.this, "Please Fill Out Description", Toast.LENGTH_LONG).show();
                } else if (name.isEmpty()) {
                    Toast.makeText(AddNewListActivity.this, "Please Fill Out Name", Toast.LENGTH_LONG).show();

                } else {
                    Intent intent = new Intent();
                    intent.putExtra(newListName, name);
                    intent.putExtra(newListDescription, description);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });


    }
}
