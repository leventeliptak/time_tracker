package com.example.levi.time_tracker.interactor;

import com.example.levi.time_tracker.TimeTrackerApplication;
import com.example.levi.time_tracker.interactor.events.DeleteProcessEvent;
import com.example.levi.time_tracker.interactor.events.SaveProcessEvent;
import com.example.levi.time_tracker.repository.Repository;
import com.example.levi.time_tracker.model.Process;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by Levi on 2017.04.20..
 */

public class ProcessCreatorInteractor {

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    public ProcessCreatorInteractor() {
        TimeTrackerApplication.injector.inject(this);
    }

    public void SaveProcess(Process process) {
        SaveProcessEvent event = new SaveProcessEvent();
        try {
            repository.updateProcess(process);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }

    }

    public void DeleteProcess(Process process) {
        DeleteProcessEvent event = new DeleteProcessEvent();
        try {
            repository.removeProcess(process);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
