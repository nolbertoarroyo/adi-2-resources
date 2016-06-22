package com.test.mytodolist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nolbertoarroyo on 6/21/16.
 */
public class CustomAdapter extends BaseAdapter {
    private ArrayList<Category> categoryList;
    private Context context;
    private ViewHolder viewHolder;

    public CustomAdapter(ArrayList<Category> categoryList, Context context) {
        this.categoryList = categoryList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return categoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView== null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
            viewHolder= new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Category currentCategory = categoryList.get(position);

        viewHolder.listDescription.setText(currentCategory.getName());
        viewHolder.listName.setText(currentCategory.getDescription());

        //need onItemClickListener to go to other activity and show list
        return convertView;
    }

    public class ViewHolder {
        TextView listDescription;
        TextView listName;

        public ViewHolder(View convertView) {
            this.listDescription = (TextView) convertView.findViewById(R.id.tv_discription);
            this.listName = (TextView) convertView.findViewById(R.id.tv_name);
        }
    }
}

