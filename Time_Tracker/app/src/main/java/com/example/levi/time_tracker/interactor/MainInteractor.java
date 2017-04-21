package com.example.levi.time_tracker.interactor;

import com.example.levi.time_tracker.TimeTrackerApplication;
import com.example.levi.time_tracker.interactor.events.GetprocessesEvent;
import com.example.levi.time_tracker.interactor.events.SaveTimeInternalsEvent;
import com.example.levi.time_tracker.model.Process;
import com.example.levi.time_tracker.model.TimeInterval;
import com.example.levi.time_tracker.repository.Repository;
import de.greenrobot.event.EventBus;
import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;
/**
 * Created by Levi on 2017.04.20..
 */

public class MainInteractor {

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

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
        GetprocessesEvent  event = new GetprocessesEvent();

        try {

            event.setProcesses(repository.getProcesses());
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
