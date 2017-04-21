package com.example.levi.time_tracker.ui.statictics;

import com.example.levi.time_tracker.interactor.StaticticsInteractor;
import com.example.levi.time_tracker.model.TimeInterval;
import com.example.levi.time_tracker.ui.Presenter;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;
/**
 * Created by Levi on 2017.04.07..
 */

public class StaticticsPresenter extends Presenter<StaticticsScreen> {

    @Inject
    StaticticsInteractor staticticsInteractor;

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

    public List<TimeInterval> getStatictics() {
        return staticticsInteractor.GetStatictics(date);
    }

    public void setDate(Date date)
    {
        this.date=date;
    }
}
