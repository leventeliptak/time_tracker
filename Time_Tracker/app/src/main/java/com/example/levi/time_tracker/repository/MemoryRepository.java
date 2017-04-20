package com.example.levi.time_tracker.repository;

import android.content.Context;

import com.example.levi.time_tracker.model.Process;
import com.example.levi.time_tracker.model.TimeInterval;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Levi on 2017.04.07..
 */

public class MemoryRepository implements Repository {

    private List<Process> mProcesses;
    private List<TimeInterval> mTimeIntervals;

    @Override
    public void open(Context context) {
        mProcesses = new ArrayList<>();
        mProcesses.add(new Process("egyik"));
        mProcesses.add(new Process("masik"));

    }

    @Override
    public void close() {
        //empty
    }

    @Override
    public List<Process> getProcesses() {
        return mProcesses;
    }

    @Override
    public void saveProcesses(List<Process> processes) {
        for(Process p : processes) {
            mProcesses.add(p);
        }
    }

    @Override
    public void updateProcess(Process process) {
        Process toUpdate = null;
        for(Process p : mProcesses) {
            if(p.getName().equals(process.getName()))
            {
                toUpdate = p;
                break;
            }
        }
        if(toUpdate == null) {
            mProcesses.add(process);
        } else {
            toUpdate = process;
        }
    }

    @Override
    public void removeProcess(Process process) {
        for(Process p : mProcesses) {
            Iterator<Process> toRemove = mProcesses.iterator();
            while(toRemove.hasNext()){
                if(toRemove.equals(process)) {
                    toRemove.remove();
                    return;
                }
                toRemove.next();
            }

        }
    }

    @Override
    public void addMeasurement(TimeInterval interval) {
        mTimeIntervals.add(interval);
    }

    @Override
    public List<TimeInterval> GetTimeIntervals(Date date) {
        List<TimeInterval> ret = new ArrayList<>();
        for(TimeInterval t : mTimeIntervals) {
            if(t.getBegin().compareTo(date)<=0 && t.getEnd().compareTo(date) >= 0){
                ret.add(t);
            }
        }
        return ret;
    }
}
