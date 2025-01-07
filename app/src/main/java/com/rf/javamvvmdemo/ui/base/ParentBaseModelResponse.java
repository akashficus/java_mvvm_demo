package com.rf.javamvvmdemo.ui.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class ParentBaseModelResponse {
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("error")
    @Expose
    private String error;

    public ParentBaseModelResponse(String message, int status, String error) {
        this.message = message;
        this.status = status;
        this.error = error;
    }

    public ParentBaseModelResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
