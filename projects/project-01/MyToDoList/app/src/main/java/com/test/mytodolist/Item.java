package com.test.mytodolist;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by nolbertoarroyo on 6/22/16.
 */
public class Item implements Serializable{
    private String itemName;
    private String itemDescription;

    public Item(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
