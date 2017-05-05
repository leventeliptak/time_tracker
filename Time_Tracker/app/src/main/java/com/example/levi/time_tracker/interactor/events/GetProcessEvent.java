package com.example.levi.time_tracker.interactor.events;

import com.example.levi.time_tracker.model.Process;

/**
 * Created by Levi on 2017.05.05..
 */

public class GetProcessEvent extends Event {
    Process Process;

    public Process getProcess() {
        return Process;
    }

    public void setProcess(Process process) {
        Process = process;
    }
}
