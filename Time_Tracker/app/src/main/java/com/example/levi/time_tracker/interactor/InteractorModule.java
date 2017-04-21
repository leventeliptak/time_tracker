package com.example.levi.time_tracker.interactor;

/**
 * Created by Levi on 2017.04.19..
 */
import dagger.Module;
import dagger.Provides;
import com.example.levi.time_tracker.interactor.MainInteractor;
import com.example.levi.time_tracker.interactor.ProcessCreatorInteractor;
import com.example.levi.time_tracker.interactor.StaticticsInteractor;
@Module
public class InteractorModule {
    @Provides
    public MainInteractor provideMainInteractor() {
        return new MainInteractor();
    }

    @Provides
    public ProcessCreatorInteractor provideProcessCreatorInteractor() {
        return new ProcessCreatorInteractor();
    }

    @Provides
    public StaticticsInteractor provideStaticticsInteractor() {
        return new StaticticsInteractor();
    }

}