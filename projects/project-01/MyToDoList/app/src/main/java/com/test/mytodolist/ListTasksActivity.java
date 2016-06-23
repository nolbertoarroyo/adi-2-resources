package com.test.mytodolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListTasksActivity extends AppCompatActivity {
    private ArrayList<Item> itemList;
    private ListView itemListView;
    private SecondCustomAdapter secondCustomAdapter;
    Button backButton;
    public static final int CREATE_ITEM_REQUEST_CODE = 200;
    Category category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tasks);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        backButton = (Button)findViewById(R.id.back_button);

        itemListView = (ListView) findViewById(R.id.item_list_view);
        // populate list
        //recieving intent from MainActivity
        Intent recIntent = getIntent();
        final int position= recIntent.getIntExtra(MainActivity.CURRENT_ITEM,-1);

        category = (Category) recIntent.getSerializableExtra(MainActivity.CURRENT_LIST);

        itemList = category.getItems();

        if (itemList== null){
            itemList= new ArrayList<>();
        }
        secondCustomAdapter = new SecondCustomAdapter(itemList, ListTasksActivity.this);


        // set custom adapter on our list view
        itemListView.setAdapter(secondCustomAdapter);

        //floating button sends user to AddNewItemActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListTasksActivity.this, AddNewItemActivity.class);
                startActivityForResult(intent, CREATE_ITEM_REQUEST_CODE);

            }
        });
        //when long pressing on item in itemListView, the item is removed from the list
        itemListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                itemList.remove(secondCustomAdapter.getItem(position));
                secondCustomAdapter.notifyDataSetChanged();
                //toast message letting user know which position in the list is removed
                Toast.makeText(ListTasksActivity.this, secondCustomAdapter.getItemId(position) + " is removed", Toast.LENGTH_SHORT).show();
                return false;
                //make it show the name of the item being removed
            }
        });


        // button to go back to MainActivity
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bIntent= new Intent();

                category.setItems(itemList);
                bIntent.putExtra(MainActivity.CURRENT_LIST,category);
                bIntent.putExtra(MainActivity.CURRENT_ITEM,position);
                setResult(RESULT_OK, bIntent);
                finish();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CREATE_ITEM_REQUEST_CODE) {

            if (resultCode == RESULT_OK) {
                itemList.add(new Item(data.getStringExtra(AddNewItemActivity.newItemName),data.getStringExtra(AddNewItemActivity.newItemDescription)));
                secondCustomAdapter.notifyDataSetChanged();
            }
        }
    }




}


