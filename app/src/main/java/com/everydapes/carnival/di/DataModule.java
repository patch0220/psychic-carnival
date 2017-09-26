package com.everydapes.carnival.di;

import android.app.Application;
import android.content.Context;
import android.telephony.TelephonyManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.everydapes.carnival.data.AppPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.devland.esperandro.Esperandro;
import de.devland.esperandro.serialization.GsonSerializer;

@Module
public class DataModule {

    @Singleton
    @Provides
    TelephonyManager telephonyManager(Application application) {
        return (TelephonyManager) application.getSystemService(Context.TELEPHONY_SERVICE);
    }

    @Singleton
    @Provides
    Gson gson() {
        return new GsonBuilder()
                // .setDateFormat(DateUtil.YYYYMMDDTHHMMSS)
                .create();
    }

    @Singleton
    @Provides
    static AppPreferences appPreferences(Application application, Gson gson) {
        Esperandro.setSerializer(new GsonSerializer(gson));
        return Esperandro.getPreferences(AppPreferences.class, application);
    }
}
