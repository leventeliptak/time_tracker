package com.example.levi.time_tracker;

import android.app.Application;
import com.example.levi.time_tracker.ui.UIModule;
/**
 * Created by Levi on 2017.04.07..
 */

public class TimeTrackerApplication extends Application {

    public static TimeTrackerApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerTimeTrackerApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}
