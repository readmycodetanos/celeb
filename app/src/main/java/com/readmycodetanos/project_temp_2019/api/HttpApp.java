package com.readmycodetanos.project_temp_2019.api;

import com.readmycodetanos.lib_net.ClientBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpApp {


    private static AppService appService;
    private static Retrofit retrofit;


    public static AppService getAppService() {

        if (appService == null) {
            appService = getRetrofit().create(AppService.class);
        }

        return appService;
    }


    private static Retrofit getRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(" http://gank.io/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(ClientBuilder.getInstance())
                    .build();
        }

        return retrofit;
    }


}
