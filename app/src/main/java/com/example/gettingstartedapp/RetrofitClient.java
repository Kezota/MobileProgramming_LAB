package com.example.gettingstartedapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    static final String BASE_URL = "https://itunes.apple.com/";
    static Retrofit retrofit;

    public static ITunesApiService getApiService(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ITunesApiService.class);
    }
}
