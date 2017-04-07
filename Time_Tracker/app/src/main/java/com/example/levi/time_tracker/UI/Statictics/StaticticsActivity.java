package com.example.levi.time_tracker.UI.Statictics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import javax.inject.Inject;
import java.util.ArrayList;

import com.example.levi.time_tracker.R;
import com.example.levi.time_tracker.Model.Process;


/**
 * Created by Levi on 2017.04.07..
 */

public class StaticticsActivity extends AppCompatActivity implements StaticticsScreen{

    @Inject
    StaticticsPresenter staticticsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        staticticsPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        staticticsPresenter.detachScreen();
    }

    @Override
    public void refreshData(ArrayList<Process> processes, ArrayList<Integer> SumHours) {
        //TODO: implement
    }
}
