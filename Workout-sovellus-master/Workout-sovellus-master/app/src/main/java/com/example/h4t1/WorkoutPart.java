package com.example.h4t1;

import java.io.Serializable;

public class WorkoutPart implements Serializable {

    public int seconds;
    public String name;


    public WorkoutPart(int seconds, String name) {
        this.seconds = seconds;
        this.name = name;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
