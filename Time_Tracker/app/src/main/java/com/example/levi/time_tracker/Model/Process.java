package com.example.levi.time_tracker.model;

import android.graphics.Color;

import com.orm.dsl.Table;


import java.util.Random;

/**
 * Created by Levi on 2017.04.07..
 */

@Table
public class Process {

    private String name;
    private int color;

    public Process(String _name)
    {
        name = _name;
        Random rnd = new Random();
        color = Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean equals(Process other){
       return name.equals(other.name);
    }
}
