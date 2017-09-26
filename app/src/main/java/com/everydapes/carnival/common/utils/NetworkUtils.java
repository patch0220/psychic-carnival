package com.everydapes.carnival.common.utils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtils {

    ConnectivityManager connectivityManager;

    public NetworkUtils(ConnectivityManager connectivityManager) {
        this.connectivityManager = connectivityManager;
    }

    public boolean isConnected() {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}