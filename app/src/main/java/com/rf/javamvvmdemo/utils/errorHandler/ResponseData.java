package com.rf.javamvvmdemo.utils.errorHandler;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ResponseData<T> {
    private Status status;
    private T data; // Updated to hold a list of data
    private String message;

    // Constructor
    public ResponseData(Status status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    // Getters and Setters
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static <T> ResponseData<T> loading(T data) {
        return new ResponseData<>(Status.LOADING, data, null);
    }

    public static <T> ResponseData<T> success(T data) {
        return new ResponseData<>(Status.SUCCESS, data, null);
    }

    public static <T> ResponseData<T> error(String message) {
        return new ResponseData<>(Status.ERROR, null, message);
    }


}

