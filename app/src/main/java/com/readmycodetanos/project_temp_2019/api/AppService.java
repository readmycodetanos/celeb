package com.readmycodetanos.project_temp_2019.api;

import com.readmycodetanos.project_temp_2019.api.result.ContentBean;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AppService {

    @GET("history/content/2/1")
    Call<ContentBean> getContents( );




}
