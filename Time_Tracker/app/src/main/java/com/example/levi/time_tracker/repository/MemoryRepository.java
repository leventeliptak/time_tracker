package com.example.levi.time_tracker.repository;

import android.content.Context;

import com.example.levi.time_tracker.model.Process;
import com.example.levi.time_tracker.model.TimeInterval;

import java.sql.Date;
import java.sql.Timestamp;
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
        mProcesses = new ArrayList<Process>();
        mProcesses.add(new Process("egyik"));
        mProcesses.add(new Process("masik"));

        mTimeIntervals= new ArrayList<TimeInterval>();
        mTimeIntervals.add(new TimeInterval(mProcesses.get(0), new Timestamp(200),new Timestamp(600200)));
        mTimeIntervals.add(new TimeInterval(mProcesses.get(0), new Timestamp(4000),new Timestamp(654000)));
        mTimeIntervals.add(new TimeInterval(mProcesses.get(1), new Timestamp(200),new Timestamp(220201)));
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
    public Process getProcess(String process) {
        for(Process p : mProcesses) {
            if(p.getName().equals(process))
            {
                return p;
            }
        }
        return null;
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
            String s = null;
            s.length();
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
         //   if(t.getBegin().compareTo(date)<=0 && t.getEnd().compareTo(date) >= 0){
                ret.add(t);
        //    }
        }
        return ret;
    }
}
