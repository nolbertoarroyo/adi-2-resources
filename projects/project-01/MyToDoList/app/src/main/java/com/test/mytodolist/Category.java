package com.test.mytodolist;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by nolbertoarroyo on 6/21/16.
 */
public class Category implements Serializable{
    private String name;
    private String description;
    private ArrayList<Item> items;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
