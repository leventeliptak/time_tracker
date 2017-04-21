package com.example.levi.time_tracker.interactor;

import com.example.levi.time_tracker.TimeTrackerApplication;
import com.example.levi.time_tracker.model.TimeInterval;
import com.example.levi.time_tracker.repository.Repository;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;
/**
 * Created by Levi on 2017.04.20..
 */

public class StaticticsInteractor {

    @Inject
    Repository repository;

    public StaticticsInteractor() {
        TimeTrackerApplication.injector.inject(this);
    }

    public List<TimeInterval> GetStatictics(Date date){
       return repository.GetTimeIntervals(date);
    }
}
