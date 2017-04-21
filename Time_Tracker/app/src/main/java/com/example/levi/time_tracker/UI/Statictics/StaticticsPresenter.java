package com.example.levi.time_tracker.ui.statictics;

import com.example.levi.time_tracker.interactor.StaticticsInteractor;
import com.example.levi.time_tracker.interactor.events.GetStaticticsEvent;
import com.example.levi.time_tracker.model.TimeInterval;
import com.example.levi.time_tracker.ui.Presenter;

import java.sql.Date;
import java.util.List;
import java.util.concurrent.Executor;

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

    public StaticticsPresenter() {
    }

    @Override
    public void attachScreen(StaticticsScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
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

    }

    public void setDate(Date date)
    {
        this.date=date;
    }
}
