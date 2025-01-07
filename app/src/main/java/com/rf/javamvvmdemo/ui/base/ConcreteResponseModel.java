package com.rf.javamvvmdemo.ui.base;

import java.util.List;

public class ConcreteResponseModel<P> extends BaseResponseModel2<P> {

    private int status;
    private String message;

    public ConcreteResponseModel(List<P> data, int status, String message) {
        super(data);
        this.status = status;
        this.message = message;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
