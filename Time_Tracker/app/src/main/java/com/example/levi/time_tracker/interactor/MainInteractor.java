package com.example.levi.time_tracker.interactor;

import com.example.levi.time_tracker.TimeTrackerApplication;
import com.example.levi.time_tracker.interactor.events.GetProcessEvent;
import com.example.levi.time_tracker.interactor.events.GetProcessesEvent;
import com.example.levi.time_tracker.interactor.events.SaveTimeInternalsEvent;
import com.example.levi.time_tracker.model.TimeInterval;
import com.example.levi.time_tracker.network.TimeTrackerApi;
import com.example.levi.time_tracker.repository.Repository;
import de.greenrobot.event.EventBus;
import java.sql.Timestamp;

import javax.inject.Inject;
/**
 * Created by Levi on 2017.04.20..
 */

public class MainInteractor {

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

   // @Inject
   // TimeTrackerApi network;

    public MainInteractor() {
        TimeTrackerApplication.injector.inject(this);
    }

    public Timestamp GetTimeStamp()
    {
        return new Timestamp(System.currentTimeMillis());
    }

    public void Save(TimeInterval timeInterval)
    {

        SaveTimeInternalsEvent event = new SaveTimeInternalsEvent();
        try {

            repository.addMeasurement(timeInterval);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
    public void GetProcesses()
    {
        GetProcessesEvent event = new GetProcessesEvent();

        try {
            event.setProcesses(repository.getProcesses());
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void GetProcess(String process)
    {
        GetProcessEvent event = new GetProcessEvent();

        try {
            event.setProcess(repository.getProcess(process));
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
