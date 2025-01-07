package com.rf.javamvvmdemo.sdkInit.di;

import android.app.Application;
import android.content.Context;

import com.google.gson.GsonBuilder;
import com.rf.javamvvmdemo.BuildConfig;
import com.rf.javamvvmdemo.roomDB.JavaMVVMDemoDB;
import com.rf.javamvvmdemo.ui.base.BaseResponseModel2;
import com.rf.javamvvmdemo.ui.base.BaseResponseModel2Deserializer;
import com.rf.javamvvmdemo.utils.AuthInterceptor;
import com.rf.javamvvmdemo.utils.NetworkHelper;
import com.rf.javamvvmdemo.utils.SharedPreference;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    private final Application mApplication;

    public AppModule(Application application) {
        this.mApplication = application;
    }

    @Singleton
    @Provides
    public Context getContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(SharedPreference sharedPreference) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.addInterceptor(new AuthInterceptor(sharedPreference));

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }

        return builder
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .cache(null)
                .build();
    }

    @Provides
    @Singleton
    public Retrofit providesRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                        .setLenient()
                        .registerTypeAdapter(BaseResponseModel2.class, new BaseResponseModel2Deserializer<>())
                        .create()))
                .client(okHttpClient)
                .baseUrl("https://mocki.io/")
                .build();
    }

    @Provides
    @Singleton
    public SharedPreference provideSharedPreference(Context context) {
        return new SharedPreference(context);
    }

    @Provides
    @Singleton
    public NetworkHelper provideNetwork(Context context) {
        return new NetworkHelper(context);
    }

    @Provides
    @Singleton
    public JavaMVVMDemoDB provideJavaMVVMDemoBD(Context context) {
        return JavaMVVMDemoDB.getDatabase(context);
    }
}
