package com.example.levi.time_tracker.UI;

/**
 * Created by Levi on 2017.04.07..
 */

import android.content.Context;

import com.example.levi.time_tracker.UI.Main.MainPresenter;
import com.example.levi.time_tracker.UI.ProcessCreator.ProcessCreatorPresenter;
import com.example.levi.time_tracker.UI.Statictics.StaticticsPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public ProcessCreatorPresenter provideProcessCreatorPresenter() {
        return new ProcessCreatorPresenter();
    }

    @Provides
    @Singleton
    public StaticticsPresenter provideStaticticsPresenter() {
        return new StaticticsPresenter();
    }
}
