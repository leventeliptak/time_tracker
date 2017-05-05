package com.example.levi.time_tracker.ui.main;

import com.example.levi.time_tracker.interactor.MainInteractor;
import com.example.levi.time_tracker.interactor.events.GetProcessEvent;
import com.example.levi.time_tracker.interactor.events.GetProcessesEvent;
import com.example.levi.time_tracker.interactor.events.SaveTimeInternalsEvent;
import com.example.levi.time_tracker.model.TimeInterval;
import com.example.levi.time_tracker.network.TimeTrackerApi;
import com.example.levi.time_tracker.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.levi.time_tracker.TimeTrackerApplication.injector;

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

    String searched;

    @Override
    public void attachScreen(MainScreen screen) {

        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {

        bus.unregister(this);
        super.detachScreen();
    }

    public void ChangeToProcess(String process)
    {
        TimeInterval toMeasure=measured;
        if(measured != null ) {
            measured.setEnd(mainInteractor.GetTimeStamp());
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    mainInteractor.Save(measured);
                }
            });
            measured = null;
            GetProcesses();
        }
        if(toMeasure != null  && !toMeasure.getProcess().getName().equals(process)){
            searched=process;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    mainInteractor.GetProcess(searched);
                }
            });
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

    public void onEventMainThread(GetProcessesEvent event) {
        if(measured == null)
            screen.refreshGridview(event.getProcesses(),null);
        else
            screen.refreshGridview(event.getProcesses(),measured.getProcess().getName());
    }

    public void  onEventMainThread(SaveTimeInternalsEvent event)
    {

    }

    public void onEventMainThread(GetProcessEvent event)
    {
        measured = new TimeInterval(event.getProcess(),mainInteractor.GetTimeStamp(),mainInteractor.GetTimeStamp());
        GetProcesses();
    }

    public void changeToProcessCreator(String s)
    {
        screen.startProcessCreator(s);
    }

    public void  changeToStatictics()
    {
        screen.startStatictics();
    }
}
