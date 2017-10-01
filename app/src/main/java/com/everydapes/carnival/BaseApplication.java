package com.everydapes.carnival;

import android.app.Application;
import android.content.Context;

import com.everydapes.carnival.di.AppComponent;
import com.everydapes.carnival.di.AppModule;
import com.everydapes.carnival.di.DaggerAppComponent;
import com.everydapes.carnival.di.DataModule;
import com.everydapes.carnival.di.NetworkModule;
import com.everydapes.carnival.di.SystemModule;


public class BaseApplication extends Application {

    protected AppComponent appComponent;

    public static BaseApplication get(Context context) {
        return (BaseApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .dataModule(new DataModule())
                .networkModule(new NetworkModule())
                .systemModule(new SystemModule())
                .build();
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
