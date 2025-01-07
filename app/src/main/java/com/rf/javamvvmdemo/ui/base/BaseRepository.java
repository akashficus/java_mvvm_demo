package com.rf.javamvvmdemo.ui.base;

import android.content.Context;
import android.util.Log;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.json.JSONObject;

public abstract class BaseRepository {

    /**
     * Executes an API call and handles the response.
     *
     * @param call           Retrofit Call object
     * @param context        Application or Activity context
     * @param onSuccess      Callback for successful response
     * @param onError        Callback for error response
     * @param <T>            Generic type parameter for response data
     */
    public <T> void executeApiCall(
            Call<BaseResponseModel<T>> call,
            Context context,
            OnSuccessCallback<T> onSuccess,
            OnErrorCallback onError
    ) {
        call.enqueue(new Callback<BaseResponseModel<T>>() {
            @Override
            public void onResponse(Call<BaseResponseModel<T>> call, Response<BaseResponseModel<T>> response) {
                try {
                    if (response.isSuccessful() && response.body() != null) {
                        BaseResponseModel<T> body = response.body();
                        if (body.getData() != null) {
                            onSuccess.onSuccess(body.getData());
                        } else {
                            onError.onError(body.getMessage() != null ? body.getMessage() : "Something went wrong");
                        }
                    } else {
                        String errorMessage = getErrorMessage(response);
                        onError.onError(errorMessage != null ? errorMessage : "Something went wrong");
                    }
                } catch (Exception e) {
                    Log.e("BaseRepository", "Error parsing response", e);
                    onError.onError("Something went wrong");
                }
            }

            @Override
            public void onFailure(Call<BaseResponseModel<T>> call, Throwable t) {
                if (t.getMessage() != null && t.getMessage().toLowerCase().contains("failed to connect")) {
                    onError.onError("No Internet Connect");
                } else {
                    onError.onError("Something went wrong");
                }
            }
        });
    }

    /**
     * Extracts an error message from the response.
     *
     * @param response Retrofit Response object
     * @return Extracted error message or null if parsing fails
     */
    private String getErrorMessage(Response<?> response) {
        try {
            if (response.errorBody() != null) {
                String errorBody = response.errorBody().string();
                JSONObject jsonObject = new JSONObject(errorBody);
                return jsonObject.optString("error", null);
            }
        } catch (IOException | org.json.JSONException e) {
            Log.e("BaseRepository", "Error extracting error message", e);
        }
        return null;
    }

    // Callback interface for success
    public interface OnSuccessCallback<T> {
        void onSuccess(T data);
    }

    // Callback interface for error
    public interface OnErrorCallback {
        void onError(String errorMessage);
    }

    public interface onMessageCallback {
        void onMessage(String message);
    }

    /**
     * Executes an API call with response handling specific to the given model.
     *
     * @param call           Retrofit Call object
     * @param success        Callback for successful response with data payload
     * @param fail           Callback for failed response with error message
     * @param context        Application or Activity context
     * @param message        Callback to show message
     * @param <P>            Generic type parameter for response data
     */
    public <P> void execute2(
            Call<BaseResponseModel2<P>> call,
            OnSuccessCallback<List<P>> success,
            OnErrorCallback fail,
            Context context,
            onMessageCallback message
    ) {
        call.enqueue(new Callback<BaseResponseModel2<P>>() {
            @Override
            public void onResponse(Call<BaseResponseModel2<P>> call, Response<BaseResponseModel2<P>> response) {
                try {
                    if (response.isSuccessful() && response.body() != null) {
                        BaseResponseModel2<P> body = response.body();
                        if (body.getData() != null) {
                            if (body.getStatus() == 200) {
                                success.onSuccess(body.getData());
                            } else if (body.getStatus() == 201) {
                                success.onSuccess(body.getData());
                            } else {
                                fail.onError(body.getMessage() != null ? body.getMessage() : "Something went wrong");
                            }
                        } else {
                            fail.onError(body.getMessage() != null ? body.getMessage() : "Something went wrong");
                        }
                    } else {
                        String errorMessage = getErrorMessage(response);
                        fail.onError(errorMessage != null ? errorMessage : "Something went wrong");
                    }
                } catch (Exception e) {
                    fail.onError("Something went wrong");
                }
            }

            @Override
            public void onFailure(Call<BaseResponseModel2<P>> call, Throwable t) {
                if (t.getMessage() != null && t.getMessage().toLowerCase().contains("failed to connect")) {
                    fail.onError("No Internet Connect");
                } else {
                    fail.onError("Something went wrong");
                }
            }
        });
    }


}

