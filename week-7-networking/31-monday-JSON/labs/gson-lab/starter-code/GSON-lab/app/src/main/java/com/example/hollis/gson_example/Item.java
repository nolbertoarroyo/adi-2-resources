package com.example.hollis.gson_example;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nolbertoarroyo on 7/18/16.
 */
public class Item {
    private String title;
    private double lat;
    @SerializedName("long")
    private double longatude;
    private String link;
    private String pubDate;
    private Condition condition;

}
