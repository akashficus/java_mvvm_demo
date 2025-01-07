package com.rf.javamvvmdemo.utils.errorHandler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallBackJava<T> implements Callback<T> {

    private OnResponse<T> onResponse;
    private OnFailure onFailure;

    // Interface for handling successful response
    public interface OnResponse<T> {
        void onResponse(Response<T> response);
    }

    // Interface for handling failure
    public interface OnFailure {
        void onFailure(Throwable t);
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (onFailure != null) {
            onFailure.onFailure(t);
        }
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (onResponse != null) {
            onResponse.onResponse(response);
        }
    }

    // Setter methods for response and failure callbacks
    public void setOnResponse(OnResponse<T> onResponse) {
        this.onResponse = onResponse;
    }

    public void setOnFailure(OnFailure onFailure) {
        this.onFailure = onFailure;
    }
}