package com.example.levi.time_tracker.interactor;

import com.example.levi.time_tracker.TimeTrackerApplication;
import com.example.levi.time_tracker.model.Process;
import com.example.levi.time_tracker.model.TimeInterval;
import com.example.levi.time_tracker.repository.Repository;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;
/**
 * Created by Levi on 2017.04.20..
 */

public class MainInteractor {

    @Inject
    Repository repository;

    public MainInteractor() {
        TimeTrackerApplication.injector.inject(this);
    }

    public Timestamp GetTimeStamp()
    {
        return new Timestamp(System.currentTimeMillis());
    }

    public void Save(TimeInterval timeInterval)
    {
        repository.addMeasurement(timeInterval);
    }
    public List<Process> GetProcesses()
    {
        return repository.getProcesses();
    }
}
