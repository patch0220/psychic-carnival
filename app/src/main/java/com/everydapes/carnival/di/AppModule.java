package com.everydapes.carnival.di;

import android.app.Application;

import com.everydapes.carnival.common.misc.TextHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Application application() {
        return application;
    }

    @Singleton
    @Provides
    static TextHelper textHelper(Application application) {
        return new TextHelper(application);
    }

}
