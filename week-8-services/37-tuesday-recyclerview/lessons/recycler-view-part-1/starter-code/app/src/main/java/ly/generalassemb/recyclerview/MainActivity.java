package ly.generalassemb.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    // TODO Step 3, declare variable here
    private RecyclerView recyclerView;
    private CustomRecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private LinkedList<String> dataList = new LinkedList<String>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO Step 4 will go here


        // TODO: Step 4a) find recycler view from xml
            recyclerView = (RecyclerView)findViewById(R.id.recycler_view);



        // TODO: Step 4b) add data to our list
            dataList.add("Raiders");
            dataList.add("Lakers");
            dataList.add("Barcelona");
            dataList.add("Warriors");



        // TODO: Step 4c) create and set linear layout manager on recycler view
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);




        // TODO: Step 4d) create the custom adapter with our data and set it on the recyclerView
        adapter = new CustomRecyclerViewAdapter(dataList);
        recyclerView.setAdapter(adapter);



    }
}
