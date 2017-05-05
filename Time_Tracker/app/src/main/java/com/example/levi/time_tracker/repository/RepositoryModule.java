package com.example.levi.time_tracker.repository;

/**
 * Created by Levi on 2017.04.07..
 */

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    @Singleton
    @Provides
    public Repository provideRepository() {
        return new MemoryRepository();
    }
}
