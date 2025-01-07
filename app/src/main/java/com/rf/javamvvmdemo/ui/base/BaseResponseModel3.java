package com.rf.javamvvmdemo.ui.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseResponseModel3<P> extends ParentBaseModelResponse {

    @SerializedName("data")
    @Expose
    private List<P> data;

    public BaseResponseModel3(List<P> data) {
        this.data = data;
    }

    public List<P> getData() {
        return data;
    }

    public void setData(List<P> data) {
        this.data = data;
    }
}
