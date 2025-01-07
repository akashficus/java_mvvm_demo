package com.rf.javamvvmdemo.ui.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BaseResponseModel<P> extends ParentBaseModelResponse {

    @SerializedName("data")
    @Expose
    private P data;

    public BaseResponseModel(P data) {
        this.data = data;
    }

    public P getData() {
        return data;
    }

    public void setData(P data) {
        this.data = data;
    }
}

