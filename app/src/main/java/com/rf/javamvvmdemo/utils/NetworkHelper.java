package com.rf.javamvvmdemo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import javax.inject.Inject;

public class NetworkHelper {
    private final Context context;

    @Inject
    public NetworkHelper(Context context) {
        this.context = context;
    }

    public boolean isNetworkConnected() {
        boolean result = false;
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            Network network = connectivityManager.getActiveNetwork();
            if (network != null) {
                NetworkCapabilities activeNetwork =
                        connectivityManager.getNetworkCapabilities(network);
                if (activeNetwork != null) {
                    if (activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                        result = true;
                    }
                }
            }
        }

        return result;
    }
}
