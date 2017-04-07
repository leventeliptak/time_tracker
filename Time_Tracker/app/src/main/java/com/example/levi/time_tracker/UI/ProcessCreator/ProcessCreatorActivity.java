package com.example.levi.time_tracker.ui.processcreator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import javax.inject.Inject;

import com.example.levi.time_tracker.R;
import com.example.levi.time_tracker.model.Process;

/**
 * Created by Levi on 2017.04.07..
 */

public class ProcessCreatorActivity extends AppCompatActivity implements ProcessCreatorScreen {

    @Inject
    ProcessCreatorPresenter processCreatorPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        processCreatorPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        processCreatorPresenter.detachScreen();
    }

    @Override
    public void ShowProcess(Process process) {
        //TODO: implement
    }

    @Override
    public void RefreshColor(Color color) {
        //TODO: implement
    }
}
