package com.everydapes.carnival.screens.login.email;

import dagger.Subcomponent;

@Subcomponent(modules = {EmailLoginModule.class})
public interface EmailComponent {

    void inject(EmailLoginController emailLoginController);

}
