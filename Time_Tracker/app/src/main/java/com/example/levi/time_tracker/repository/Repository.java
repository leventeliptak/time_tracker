package com.example.levi.time_tracker.repository;

/**
 * Created by Levi on 2017.04.07..
 */

import android.content.Context;
import android.icu.util.DateInterval;

import com.example.levi.time_tracker.model.TimeInterval;
import com.example.levi.time_tracker.model.Process;

import java.sql.Date;
import java.util.List;

public interface Repository {

    void open(Context context);

    void close();

    List<Process> getProcesses();

    Process getProcess(String process);

    void saveProcesses(List<Process> processes);

    void updateProcess(Process process);

    void removeProcess(Process process);

    void addMeasurement(TimeInterval interval);

    List<TimeInterval> GetTimeIntervals(Date date);
}
