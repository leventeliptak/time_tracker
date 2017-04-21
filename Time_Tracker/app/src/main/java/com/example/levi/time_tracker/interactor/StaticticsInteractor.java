package com.example.levi.time_tracker.interactor;

import com.example.levi.time_tracker.TimeTrackerApplication;
import com.example.levi.time_tracker.interactor.events.GetStaticticsEvent;
import com.example.levi.time_tracker.model.TimeInterval;
import com.example.levi.time_tracker.repository.Repository;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by Levi on 2017.04.20..
 */

public class StaticticsInteractor {

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    public StaticticsInteractor() {
        TimeTrackerApplication.injector.inject(this);
    }

    public void GetStatictics(Date date){
        GetStaticticsEvent event = new GetStaticticsEvent();

        try {
            event.setTimeIntervals(repository.GetTimeIntervals(date));
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
