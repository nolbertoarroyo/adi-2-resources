package com.test.mytodolist;

import java.util.ArrayList;

/**
 * Created by nolbertoarroyo on 6/21/16.
 */
public class Category {
    private String name;
    private String description;
    private ArrayList<String> items;

    public Category(String name) {
        this.name = name;
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

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }
}
