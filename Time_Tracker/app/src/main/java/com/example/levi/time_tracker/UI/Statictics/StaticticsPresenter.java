package com.example.levi.time_tracker.ui.statictics;

import com.example.levi.time_tracker.TimeTrackerApplication;
import com.example.levi.time_tracker.interactor.StaticticsInteractor;
import com.example.levi.time_tracker.interactor.events.GetStaticticsEvent;
import com.example.levi.time_tracker.model.TimeInterval;
import com.example.levi.time_tracker.ui.Presenter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import static com.example.levi.time_tracker.TimeTrackerApplication.injector;
import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by Levi on 2017.04.07..
 */

public class StaticticsPresenter extends Presenter<StaticticsScreen> {

    @Inject
    StaticticsInteractor staticticsInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    Date date;

    @Override
    public void attachScreen(StaticticsScreen screen){

        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void getStatictics() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                staticticsInteractor.GetStatictics(date);
            }
        });
    }

    public void onEventMainThread(GetStaticticsEvent event) {
        if(event.getTimeIntervals() == null)return;
        ArrayList<String> processes = new ArrayList<String >();
        ArrayList<Integer> sums = new ArrayList<Integer>();
        for (TimeInterval measure : event.getTimeIntervals())
        {
            Integer min = (int)measure.getMinutes();
            int ind=-1;
            for(int i =0; i < processes.size();i++){
                if(measure.getProcess().getName().equals(processes.get(i)))
                {
                    ind=i;
                    break;
                }
            }
            if (ind>=0)
            {
                sums.set(ind,sums.get(ind)+min);
            } else {
                processes.add(measure.getProcess().getName());
                sums.add(min);
            }
        }
        screen.refreshData(processes,sums);
    }

    public void setDate(Date date)
    {
        this.date=date;
    }

    public void changeToProcessCreator() {
        screen.startProcessCreator();
    }

    public void changeToMain(){
        screen.startMain();
    }
}
