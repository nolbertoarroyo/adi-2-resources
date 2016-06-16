package ly.generalassemb.drewmahrt.listviewsindependent;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    LinkedList<String> mStringList;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instantiate your LinkedList
        mStringList = new LinkedList<String>();

        //Instantiate your adapter
        mAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, mStringList);


        //Get your ListView and set the adapter
        final ListView listView = (ListView)findViewById(R.id.myListView);
        listView.setAdapter(mAdapter);

        //Complete the FloatingActionButton onClick method to add a list item
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mStringList.add("hello");
                mAdapter.notifyDataSetChanged();
            }
        });

        //Complete the ListView onItemLongClick code to remove list items
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return true;
            }
        });

    }
}
