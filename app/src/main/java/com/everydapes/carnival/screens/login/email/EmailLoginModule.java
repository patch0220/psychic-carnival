package com.everydapes.carnival.screens.login.email;

import dagger.Module;
import dagger.Provides;

@Module
public class EmailLoginModule {

    private final EmailLoginController mainController;

    public EmailLoginModule(EmailLoginController mainController) {
        this.mainController = mainController;
    }

    @Provides
    EmailLoginPresenter presenter() {
        return new EmailLoginPresenter();
    }

}
