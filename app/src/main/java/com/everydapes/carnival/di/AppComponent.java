package com.everydapes.carnival.di;

import com.everydapes.carnival.BaseApplication;
import com.everydapes.carnival.screens.login.email.EmailComponent;
import com.everydapes.carnival.screens.login.email.EmailLoginModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, DataModule.class, NetworkModule.class, SystemModule.class})
public interface AppComponent {

    void inject(BaseApplication baseApplication);

    EmailComponent plus(EmailLoginModule emailLoginModule);

}
