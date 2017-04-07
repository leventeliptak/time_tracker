package com.example.levi.time_tracker;


import javax.inject.Singleton;
import dagger.Component;

import com.example.levi.time_tracker.UI.Main.MainActivity;
import com.example.levi.time_tracker.UI.ProcessCreator.ProcessCreatorActivity;
import com.example.levi.time_tracker.UI.Statictics.StaticticsActivity;
import com.example.levi.time_tracker.UI.UIModule;

/**
 * Created by Levi on 2017.04.07..
 */

@Singleton
@Component(modules = {UIModule.class})
public interface TimeTrackerApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(ProcessCreatorActivity processCreatorActivity);
    void inject(StaticticsActivity staticticsActivity);
}
