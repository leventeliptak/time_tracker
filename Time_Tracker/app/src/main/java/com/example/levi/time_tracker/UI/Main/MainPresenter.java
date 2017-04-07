package com.example.levi.time_tracker.ui.main;

import com.example.levi.time_tracker.ui.Presenter;
import com.example.levi.time_tracker.model.Process;

/**
 * Created by Levi on 2017.04.07..
 */

public class MainPresenter extends Presenter<MainScreen> {

    public MainPresenter() {
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void ChangeToProcess(Process process)
    {
        //TODO: implement
    }

    //process can be null at new process
    public void EditProcess(Process process)
    {
        //TODO: implement
    }

    public void ShowStatictics()
    {
        //TODO: implement
    }
}
