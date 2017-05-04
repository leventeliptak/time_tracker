package com.example.levi.time_tracker.network;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.example.levi.time_tracker.network.TimeTrackerApi;
import com.example.levi.time_tracker.utils.GsonHelper;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient().newBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(NetworkConfig.SERVICE_ENDPOINT).client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonHelper.getGson())).build();
    }

    @Provides
    @Singleton
    public TimeTrackerApi provideATimeTrackerApi(Retrofit retrofit) {
        return retrofit.create(TimeTrackerApi.class);
    }
}

