package com.example.levi.time_tracker;


import javax.inject.Singleton;
import dagger.Component;

import com.example.levi.time_tracker.interactor.ProcessCreatorInteractor;
import com.example.levi.time_tracker.interactor.StaticticsInteractor;
import com.example.levi.time_tracker.ui.main.MainActivity;
import com.example.levi.time_tracker.ui.main.MainActivity_MembersInjector;
import com.example.levi.time_tracker.ui.main.MainPresenter;
import com.example.levi.time_tracker.ui.processcreator.ProcessCreatorActivity;
import com.example.levi.time_tracker.ui.processcreator.ProcessCreatorPresenter;
import com.example.levi.time_tracker.ui.statictics.StaticticsActivity;
import com.example.levi.time_tracker.ui.UIModule;
import com.example.levi.time_tracker.repository.RepositoryModule;
import com.example.levi.time_tracker.interactor.InteractorModule;
import com.example.levi.time_tracker.interactor.MainInteractor;
import com.example.levi.time_tracker.ui.statictics.StaticticsPresenter;

/**
 * Created by Levi on 2017.04.07..
 */

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class})
public interface TimeTrackerApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(ProcessCreatorActivity processCreatorActivity);
    void inject(StaticticsActivity staticticsActivity);

    void inject(MainInteractor mainInteractor);
    void inject(ProcessCreatorInteractor processCreatorInteractor);
    void inject(StaticticsInteractor staticticsInteractor);

    void inject(TimeTrackerApplication timeTrackerApplication);

    void inject(MainPresenter mainPresenter);
    void inject(ProcessCreatorPresenter processCreatorPresenter);
    void inject(StaticticsPresenter staticticsPresenter);
}
