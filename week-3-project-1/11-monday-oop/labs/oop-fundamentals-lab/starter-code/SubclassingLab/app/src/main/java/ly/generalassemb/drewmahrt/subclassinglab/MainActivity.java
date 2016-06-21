package ly.generalassemb.drewmahrt.subclassinglab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final int ADD_LION = 100;
    public static final int ADD_SNAKE = 200;

    public static final String REQUEST_CODE = "requestCode";

    ArrayList<Animal> mAnimalArrayList;
    ArrayAdapter<Animal> mAdapter;
    Button mAddLionButton, mAddSnakeButton;
    ListView mAnimalListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Zoo zoo = Zoo.getInstance();



        if(mAnimalArrayList == null){
            mAnimalArrayList = new ArrayList<>();
        }

        mAddLionButton = (Button)findViewById(R.id.add_lion_button);
        mAddSnakeButton = (Button)findViewById(R.id.add_snake_button);

        mAdapter = new ArrayAdapter<Animal>(MainActivity.this, android.R.layout.simple_list_item_1, Zoo.animals);

        mAnimalListView = (ListView)findViewById(R.id.animal_list_view);
        mAnimalListView.setAdapter(mAdapter);

        mAddLionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CreateAnimalActivity.class);
                intent.putExtra(REQUEST_CODE, ADD_LION);
                startActivityForResult(intent, ADD_LION);
            }
        });

        mAddSnakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CreateAnimalActivity.class);
                intent.putExtra(REQUEST_CODE, ADD_SNAKE);
                startActivityForResult(intent, ADD_SNAKE);
            }
        });
        mAnimalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this,Zoo.getInstance().getAnimals().get(position).makeNoise(),Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            Animal createdAnimal = (Animal)data.getSerializableExtra(CreateAnimalActivity.ANIMAL_SERIALIZABLE_KEY);
            Zoo.animals.add(createdAnimal);
            mAdapter.notifyDataSetChanged();
        }
    }
}
