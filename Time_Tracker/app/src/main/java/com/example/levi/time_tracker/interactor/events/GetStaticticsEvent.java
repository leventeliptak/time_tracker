package com.example.levi.time_tracker.interactor.events;

import com.example.levi.time_tracker.model.Process;
import com.example.levi.time_tracker.model.TimeInterval;
import com.example.levi.time_tracker.interactor.events.Event;
import java.util.List;

/**
 * Created by Levi on 2017.04.21..
 */

public class GetStaticticsEvent extends Event {

    List<TimeInterval> timeIntervals;

    public List<TimeInterval> getTimeIntervals() {
        return timeIntervals;
    }

    public void setTimeIntervals(List<TimeInterval> timeIntervals) {
        this.timeIntervals = timeIntervals;
    }
}
