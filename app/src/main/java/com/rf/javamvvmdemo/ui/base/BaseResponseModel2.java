package com.rf.javamvvmdemo.ui.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseResponseModel2<P> extends ParentBaseModelResponse {

    @SerializedName("data")
    @Expose
    private List<P> data;

    public BaseResponseModel2(List<P> data) {
        this.data = data;
    }

    public List<P> getData() {
        return data;
    }

    public void setData(ArrayList<P> data) {
        this.data = data;
    }
}
