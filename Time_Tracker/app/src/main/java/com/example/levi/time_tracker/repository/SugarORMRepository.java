package com.example.levi.time_tracker.repository;

import android.content.Context;

import com.example.levi.time_tracker.model.Process;
import com.example.levi.time_tracker.model.TimeInterval;
import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import static com.example.levi.time_tracker.model.TimeInterval.*;
import static com.orm.SugarRecord.findWithQuery;
import static com.orm.SugarRecord.isSugarEntity;

/**
 * Created by Levi on 2017.04.07..
 */

public class SugarORMRepository implements Repository {
    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Process> getProcesses() {
       return SugarRecord.listAll(Process.class);
    }

    @Override
    public void saveProcesses(List<Process> processes) {
        SugarRecord.saveInTx(processes);
    }

    @Override
    public void updateProcess(Process process) {
        SugarRecord.save(process);
    }

    @Override
    public void removeProcess(Process process) {
        SugarRecord.delete(process);
    }

    @Override
    public void addMeasurement(TimeInterval interval) {
        SugarRecord.save(interval);
    }

    @Override
    public List<TimeInterval> GetTimeIntervals(Date date) {

         List<TimeInterval> result = findWithQuery(TimeInterval.class,
                "SELECT * FROM ENTITY WHERE ? BETWEEN  begin AND  end)", date.toString() );
        return result;
    }
}
