package com.test.mytodolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Category> homeList;
    private ListView homeListView;
    private CustomAdapter customAdapter;
    public static final int CREATE_LIST_REQUEST_CODE =100;
    public static final int GET_LIST_REQUEST_CODE = 107;
    public static final String CURRENT_ITEM="current Item";
    public static final String CURRENT_LIST="current list";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        homeListView = (ListView)findViewById(R.id.lists_list_view);
        // populate list
        homeList = new ArrayList<>();
        Log.d("homeList initialized", homeList.toString());

        //declare customadapter
        customAdapter = new CustomAdapter(homeList,MainActivity.this);
        Log.d("customAdapter", " custom adapter initialized");

        // set custom adapter on our list view
        homeListView.setAdapter(customAdapter);
        Log.d("homelistView", " custom adapter set");

        //create onItemClickListener and an onItemLongClickListener



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, AddNewListActivity.class);
                startActivityForResult(intent,CREATE_LIST_REQUEST_CODE);

            }
        });



        homeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent updateIntent = new Intent(MainActivity.this,ListTasksActivity.class);
                Category currentCategory = homeList.get(position);
                updateIntent.putExtra(CURRENT_ITEM,position);
                updateIntent.putExtra(CURRENT_LIST,currentCategory);
                startActivityForResult(updateIntent,GET_LIST_REQUEST_CODE);
            }
        });

        homeListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                homeList.remove(customAdapter.getItem(position));
                customAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,customAdapter.getItemId(position)+ " is removed",Toast.LENGTH_SHORT).show();
                return false;
                //make it show the name of the list being removed
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==CREATE_LIST_REQUEST_CODE){

         if (resultCode==RESULT_OK){
            homeList.add(new Category(data.getStringExtra(AddNewListActivity.newListName),data.getStringExtra(AddNewListActivity.newListDescription)));
            customAdapter.notifyDataSetChanged();
         }

        }
        if (requestCode==GET_LIST_REQUEST_CODE){
            if (resultCode==RESULT_OK){

                Category category2 = (Category) data.getSerializableExtra(MainActivity.CURRENT_LIST);
                int newPosition = data.getIntExtra(MainActivity.CURRENT_ITEM,-1);
                homeList.get(newPosition).setItems(category2.getItems());
                customAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
