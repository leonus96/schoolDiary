package com.leonus96.joseph.siscolegio.API;

import com.leonus96.joseph.siscolegio.Models.TokenManager;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by joseph on 03/05/17.
 */

public interface ColegioService {
    @FormUrlEncoded
    @POST("singin")
    Call<TokenManager> logIn(@Field("dni") String dni, @Field("contraseña") String contraseña);
}
