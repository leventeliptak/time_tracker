package com.example.levi.time_tracker.ui;

/**
 * Created by Levi on 2017.04.07..
 */

public abstract class Presenter<S> {
    protected S screen;

    public void attachScreen(S screen) {
        this.screen = screen;
    }

    public void detachScreen() {
        this.screen = null;
    }
}