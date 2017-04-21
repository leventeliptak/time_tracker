package com.example.levi.time_tracker;

import android.app.Application;
import com.example.levi.time_tracker.ui.UIModule;
import com.example.levi.time_tracker.repository.Repository;

import javax.inject.Inject;

/**
 * Created by Levi on 2017.04.07..
 */

public class TimeTrackerApplication extends Application {

    @Inject
    Repository repository;

    public static TimeTrackerApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerTimeTrackerApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();

        injector.inject(this);
        repository.open(getApplicationContext());
    }
}
