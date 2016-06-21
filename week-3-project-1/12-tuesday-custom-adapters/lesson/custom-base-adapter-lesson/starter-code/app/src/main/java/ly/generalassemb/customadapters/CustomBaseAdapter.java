package ly.generalassemb.customadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Custom Adapter for our two TextViews and single Button.
 *
 * It holds a list of Animals and binds the animal name to
 * firstTextView, animal sound to secondTextView.
 *
 * When button is clicked a toast is made with animal name saying
 * animal sound ( i.e. cow says moo ).
 */
public class CustomBaseAdapter extends BaseAdapter {
    private ArrayList<Animal> animals;
    private Context context;
    private ViewHolder viewHolder;

    public CustomBaseAdapter(ArrayList<Animal> animals, Context context) {
        this.animals = animals;
        this.context = context;
    }



    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView= LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
            viewHolder = new ViewHolder(convertView);}
        else{
            viewHolder = (ViewHolder)convertView.getTag();

        }



        final Animal currentAnimal =animals.get(position);

        viewHolder.firstTextView.setText(currentAnimal.getName());
        viewHolder.secondTextView.setText(currentAnimal.getSound());

        final String toastText = currentAnimal.getName() + " says: "+ currentAnimal.getSound();

        viewHolder.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();

            }
        });

        return convertView;
    }
    public class ViewHolder{
        TextView firstTextView;
        TextView secondTextView;
        Button button1;

        public ViewHolder(View convertView){
            TextView firstTextView = (TextView)convertView.findViewById(R.id.list_item_tv_first);
            TextView secondTextView = (TextView)convertView.findViewById(R.id.list_item_tv_second);
            Button button1 = (Button)convertView.findViewById(R.id.list_item_button);
        }
    }

    // TODO: implement the rest of the CustomBaseAdapter class


    // hint: Create constructor first. Implement 4 methods next.



    // TODO: Bonus - use a ViewHolder!
}
