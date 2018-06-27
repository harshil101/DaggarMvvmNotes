package com.app.daggarmvvmnotes;

import com.app.daggarmvvmnotes.viewmodels.MainViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Things that live for the duration of the application and will be injected into whatever the
 * component defines
 */
@Module
public class ApplicationModule {
    public ApplicationModule() {
    }

    @Provides
    @Singleton
    MainViewModel provideMainViewModel() {
        return new MainViewModel();
    }
}