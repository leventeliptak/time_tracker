package com.example.levi.time_tracker.interactor.events;

import com.example.levi.time_tracker.model.Process;

import com.example.levi.time_tracker.interactor.events.Event;
import java.util.List;

/**
 * Created by Levi on 2017.04.21..
 */

public class GetProcessesEvent extends Event{
    List<Process> Processes;

    public List<Process> getProcesses() {
        return Processes;
    }

    public void setProcesses(List<Process> processes) {
        Processes = processes;
    }
}
