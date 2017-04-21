package com.example.levi.time_tracker.ui.main;

import com.example.levi.time_tracker.interactor.MainInteractor;
import com.example.levi.time_tracker.interactor.events.GetprocessesEvent;
import com.example.levi.time_tracker.interactor.events.SaveTimeInternalsEvent;
import com.example.levi.time_tracker.model.TimeInterval;
import com.example.levi.time_tracker.ui.Presenter;
import com.example.levi.time_tracker.model.Process;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by Levi on 2017.04.07..
 */

public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    MainInteractor mainInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

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
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    mainInteractor.Save(measured);
                    }
                });
            measured = null;
            ChangeToProcess(process);
        }
    }

    public void GetProcesses()
    {
        executor.execute(new Runnable() {
            @Override
            public void run() {
               mainInteractor.GetProcesses();
            }
        });
    }

    public void onEventMainThread(GetprocessesEvent event) {

    }

    public void  onEvetMainThread(SaveTimeInternalsEvent event)
    {

    }
}
