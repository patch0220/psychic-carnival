package com.everydapes.carnival.di;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;

import com.google.gson.Gson;
import com.everydapes.carnival.common.utils.NetworkUtils;
import com.everydapes.carnival.data.AppPreferences;
import com.everydapes.carnival.network.ApiEndpoints;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Singleton
    @Provides
    CallAdapter.Factory callAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Singleton
    @Provides
    ConnectivityManager connectivityManager(Application application) {
        return (ConnectivityManager) application.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @Provides
    Retrofit retrofit(Gson gson, final AppPreferences appPreferences, CallAdapter.Factory callAdapterFactory) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        return new Retrofit.Builder()
                .baseUrl(ApiEndpoints.BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(callAdapterFactory)
                .build();
    }

    @Provides
    static NetworkUtils networkUtil(ConnectivityManager connectivityManager) {
        return new NetworkUtils(connectivityManager);
    }

}
