package com.example.levi.time_tracker.ui.processcreator;

import android.content.Intent;
import android.graphics.Color;
import com.example.levi.time_tracker.model.Process;
import com.example.levi.time_tracker.ui.statictics.StaticticsActivity;

/**
 * Created by Levi on 2017.04.07..
 */

public interface ProcessCreatorScreen {

    public void RefreshName(String name);
    void RefreshColor(Color color);

    public void startStatictics();
    public void startMain();
}
