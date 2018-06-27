package com.app.daggarmvvmnotes;

import android.app.Application;
import android.content.Context;

import com.app.daggarmvvmnotes.retrowebservices.NotesApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends Application {
    private ApplicationComponent mComponent;
    private OkHttpClient client;
    NotesApi coreApi;

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }
    @Override
    public void onCreate() {
        super.onCreate();
        //Initializing daggar 2
        mComponent = DaggerApplicationComponent
                .builder().applicationModule(new ApplicationModule())
                .build();
        setHttpClient();
        initCoreApiRetrofit();
    }

    //Setting interceptor and http client
    private void setHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }

    //Initializing retrofit components
    private void initCoreApiRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.wander.today")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        coreApi = retrofit.create(NotesApi.class);
    }

    public NotesApi getCoreApi() {
        return coreApi;
    }


    public ApplicationComponent getComponent() {
        return mComponent;
    }
}
