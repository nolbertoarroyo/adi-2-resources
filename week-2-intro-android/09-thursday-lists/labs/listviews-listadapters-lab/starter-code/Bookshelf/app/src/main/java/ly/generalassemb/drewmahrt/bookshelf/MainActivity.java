package ly.generalassemb.drewmahrt.bookshelf;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BaseAdapter mTitleAdapter;
    BaseAdapter mYearAdapter;
    BaseAdapter mAuthorAdapter;
    List<Book> mBookList;
    //TODO: Define your other Adapters

    //TODO: Define your ListView
    ListView myListView;

    //TODO: Define your Book List


    Button sortTitle;
    Button sortAuthor;
    Button sortYear;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sortTitle = (Button)findViewById(R.id.sortTitle);
        sortAuthor = (Button)findViewById(R.id.sortAuthor);
        sortAuthor = (Button)findViewById(R.id.sortYear);
        //TODO: Instantiate List
        mBookList = generateBooks();

        //TODO: Instantiate BaseAdapters for year, author, title
        //Below is a partially complete example for one Adapter
        mTitleAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return mBookList.size();
            }

            @Override
            public Object getItem(int position) {
                return mBookList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = convertView;

                if (convertView == null) {
                    LayoutInflater li = (LayoutInflater) MainActivity.this
                            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    v = li.inflate(R.layout.book_list_item, null);
                }

                TextView textView1 = (TextView)v.findViewById(R.id.text1);
                TextView textView2 =(TextView)v.findViewById(R.id.text2);
                TextView textView3 = (TextView)v.findViewById(R.id.text3);
                //TODO: Get other TextViews

                textView1.setText("Title: "+mBookList.get(position).getTitle());
                textView2.setText("Author: "+mBookList.get(position).getAuthor());
                textView3.setText("Year: "+mBookList.get(position).getYear());
                //TODO: Set text for other TextViews

                return v;
            }
        };
        mAuthorAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return mBookList.size();
            }

            @Override
            public Object getItem(int position) {
                return mBookList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = convertView;

                if (convertView == null) {
                    LayoutInflater li = (LayoutInflater) MainActivity.this
                            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    v = li.inflate(R.layout.book_list_item, null);
                }

                TextView textView1 = (TextView)v.findViewById(R.id.text1);
                TextView textView2 =(TextView)v.findViewById(R.id.text2);
                TextView textView3 = (TextView)v.findViewById(R.id.text3);
                //TODO: Get other TextViews

                textView1.setText("Title: "+mBookList.get(position).getTitle());
                textView2.setText("Author: "+mBookList.get(position).getAuthor());
                textView3.setText("Year: "+mBookList.get(position).getYear());
                //TODO: Set text for other TextViews

                return v;
            }
        };
        mYearAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return mBookList.size();
            }

            @Override
            public Object getItem(int position) {
                return mBookList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = convertView;

                if (convertView == null) {
                    LayoutInflater li = (LayoutInflater) MainActivity.this
                            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    v = li.inflate(R.layout.book_list_item, null);
                }

                TextView textView1 = (TextView)v.findViewById(R.id.text1);
                TextView textView2 =(TextView)v.findViewById(R.id.text2);
                TextView textView3 = (TextView)v.findViewById(R.id.text3);
                //TODO: Get other TextViews

                textView1.setText("Title: "+mBookList.get(position).getTitle());
                textView2.setText("Author: "+mBookList.get(position).getAuthor());
                textView3.setText("Year: "+mBookList.get(position).getYear());
                //TODO: Set text for other TextViews

                return v;
            }
        };
        myListView = (ListView)findViewById(R.id.listView1);
        myListView.setAdapter(mTitleAdapter);


        //TODO: Set listeners for buttons
        sortTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myListView.setAdapter(mTitleAdapter);
                mTitleAdapter.notifyDataSetChanged();
            }
        });
        sortAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myListView.setAdapter(mAuthorAdapter);
                mAuthorAdapter.notifyDataSetChanged();
            }
        });
        sortYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           myListView.setAdapter(mYearAdapter);
                mYearAdapter.notifyDataSetChanged();
            }
        });

    }

    //Method to generate a list of Books
    private List<Book> generateBooks(){
        List<Book> books = new ArrayList<>();

        books.add(new Book("Apples Book","Brad","1950"));
        books.add(new Book("Cats Book","Ryan","1920"));
        books.add(new Book("Eagles Book","Kate","1987"));
        books.add(new Book("Strawberries Cathy","Brad","1982"));
        books.add(new Book("Dogs Book","Tom","2005"));
        books.add(new Book("Ants Book","Zane","2001"));

        return books;
    }
}
