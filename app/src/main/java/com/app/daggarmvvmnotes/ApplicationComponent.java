package com.app.daggarmvvmnotes;

import com.app.daggarmvvmnotes.activities.CreateNoteActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Defines injections at the application level
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(CreateNoteActivity activity);
}