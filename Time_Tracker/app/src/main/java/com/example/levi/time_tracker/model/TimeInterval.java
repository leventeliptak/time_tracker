package com.example.levi.time_tracker.model;

import com.orm.dsl.Table;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by Levi on 2017.04.07..
 */


@Table
public class TimeInterval {
    Timestamp begin;
    Timestamp end;
    Process process;

    public TimeInterval(Process process, Timestamp begin, Timestamp end)
    {
        this.begin = begin;
        this.end = end;
        this.process = process;
    }

    public Timestamp getBegin() {
        return begin;
    }

    public void setBegin(Timestamp begin) {
        this.begin = begin;
    }

    public Timestamp getEnd() {
        return end;
    }

    public long getMinutes(){
        return (end.getTime()-begin.getTime())/60000;
    }
    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        process = process;
    }
}
