package com.test.mytodolist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nolbertoarroyo on 6/22/16.
 */
public class SecondCustomAdapter extends BaseAdapter {
    private ArrayList<Item> itemList;
    private Context context;
    private ViewHolder viewHolder;
    public static final String RETURN_POSITION="return position";

    public SecondCustomAdapter(ArrayList<Item> itemList, Context context) {
        super();
        this.itemList = itemList;
        this.context = context;
    }
    public static final int CREATE_ITEM= 111;
    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView== null){
            convertView= LayoutInflater.from(context).inflate(R.layout.second_list_item,parent,false);
            viewHolder= new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
         Item currentItem = itemList.get(position);

        viewHolder.itemDescription.setText(currentItem.getItemDescription());
        viewHolder.itemName.setText(currentItem.getItemName());


        viewHolder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddNewItemActivity.class);
                intent.putExtra(RETURN_POSITION,position);
                ((ListTasksActivity) context).startActivityForResult(intent, CREATE_ITEM);

            }
        });

        return convertView;
    }

    public class ViewHolder {
        TextView itemDescription;
        TextView itemName;
        CheckBox completed;
        Button edit;
        EditText editDescription;
        EditText editName;

        public ViewHolder(View convertView) {
            this.itemDescription = (TextView) convertView.findViewById(R.id.tv_item_discription);
            this.itemName = (TextView) convertView.findViewById(R.id.tv_item_name);
            this.completed = (CheckBox) convertView.findViewById(R.id.done_check);
            this.edit=(Button)convertView.findViewById(R.id.edit_button);
            this.editDescription=(EditText)convertView.findViewById(R.id.item_description);
            this.editName=(EditText)convertView.findViewById(R.id.item_name);

        }
    }
}

