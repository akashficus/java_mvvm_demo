package com.rf.javamvvmdemo.utils.errorHandler;
import java.util.List;

public class ResponseDataOfArray<T> {
    private Status status;
    private List<T> data;
    private String message;

    public ResponseDataOfArray(Status status, List<T> data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public List<T> getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public static <T> ResponseDataOfArray<T> loading(List<T> data) {
        return new ResponseDataOfArray<>(Status.LOADING, data, null);
    }

    public static <T> ResponseDataOfArray<T> success(List<T> data) {
        return new ResponseDataOfArray<>(Status.SUCCESS, data, null);
    }

    public static <T> ResponseDataOfArray<T> error(String message) {
        return new ResponseDataOfArray<>(Status.ERROR, null, message);
    }
}
