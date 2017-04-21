package com.example.levi.time_tracker.ui.main;

import com.example.levi.time_tracker.interactor.MainInteractor;
import com.example.levi.time_tracker.model.TimeInterval;
import com.example.levi.time_tracker.ui.Presenter;
import com.example.levi.time_tracker.model.Process;

import java.util.List;

import javax.inject.Inject;
/**
 * Created by Levi on 2017.04.07..
 */

public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    MainInteractor mainInteractor;

    TimeInterval measured;

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
        if( measured == null)
        {
            if(process == null){return;}
            measured = new TimeInterval(process,mainInteractor.GetTimeStamp(),mainInteractor.GetTimeStamp());
        } else {
            measured.setEnd(mainInteractor.GetTimeStamp());
            mainInteractor.Save(measured);
            measured = null;
            ChangeToProcess(process);
        }
    }

    public List<Process> GetProcesses()
    {
       return mainInteractor.GetProcesses();
    }
}
