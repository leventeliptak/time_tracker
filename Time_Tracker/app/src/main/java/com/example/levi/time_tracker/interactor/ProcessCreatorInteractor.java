package com.example.levi.time_tracker.interactor;

import com.example.levi.time_tracker.TimeTrackerApplication;
import com.example.levi.time_tracker.repository.Repository;
import com.example.levi.time_tracker.model.Process;

import javax.inject.Inject;
/**
 * Created by Levi on 2017.04.20..
 */

public class ProcessCreatorInteractor {

    @Inject
    Repository repository;

    public ProcessCreatorInteractor() {
        TimeTrackerApplication.injector.inject(this);
    }

    public void SaveProcess(Process process) {
        repository.updateProcess(process);
    }

    public void DeleteProcess(Process process) {
        repository.removeProcess(process);
    }
}
