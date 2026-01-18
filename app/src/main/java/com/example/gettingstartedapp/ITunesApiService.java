package com.example.gettingstartedapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ITunesApiService {
    @GET("search")
    Call<ITunesResponse> search(
            @Query("term") String searchTerm,
            @Query("entity") String entityType,
            @Query("limit") int limit
    );


}
