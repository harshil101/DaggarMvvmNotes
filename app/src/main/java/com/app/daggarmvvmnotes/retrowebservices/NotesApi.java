package com.app.daggarmvvmnotes.retrowebservices;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

//Interface for various api
public interface NotesApi {

    @POST("example/")
    Call<BaseResponse> login(@Body BasicRequest basicRequest);
}
