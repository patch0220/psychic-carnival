package com.everydapes.carnival.di;

import android.app.Application;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.view.inputmethod.InputMethodManager;

import com.bluelinelabs.conductor.ControllerChangeHandler;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SystemModule {
    @Singleton
    @Provides
    static ConnectivityManager connectivityManager(Application application) {
        return (ConnectivityManager) application.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @Singleton
    @Provides
    static ContentResolver contentResolver(Application application) {
        return application.getContentResolver();
    }

    @Singleton
    @Provides
    static WifiManager wifiManager(Application application) {
        return (WifiManager) application.getSystemService(Context.WIFI_SERVICE);
    }

    @Singleton
    @Provides
    static PackageManager packageManager(Application application) {
        return application.getPackageManager();
    }

    @Singleton
    @Provides
    static InputMethodManager inputMethodManager(Application application) {
        return (InputMethodManager) application.getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    @Singleton
    @Provides
    static NotificationManager notificationManager(Application application) {
        return (NotificationManager) application.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @Provides
    @Named("DefaultTransition")
    static ControllerChangeHandler fadeChangeHandler() {
        return new FadeChangeHandler();
    }

}
