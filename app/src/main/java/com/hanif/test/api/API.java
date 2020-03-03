package com.hanif.test.api;

import com.hanif.test.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("lelang")
    Call<Result> view();
}
