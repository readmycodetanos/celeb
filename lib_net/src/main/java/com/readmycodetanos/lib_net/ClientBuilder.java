package com.readmycodetanos.lib_net;

import com.readmycodetanos.lib_net.interceptor.HttpLoggingInterceptor;
import com.readmycodetanos.lib_net.util.HttpsUtils;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import okhttp3.OkHttpClient;

/**
 * ================================================
 * Date:2018/9/26
 * Description:
 * ================================================
 */
public class ClientBuilder {

    private static OkHttpClient okHttpClient;

    public static final long DEFAULT_MILLISECONDS = 60000;      //默认的超时时间
    public static long REFRESH_TIME = 300;                      //回调刷新时间（单位ms）


    public static OkHttpClient getInstance() {
        if (okHttpClient == null) {
            synchronized (ClientBuilder.class) {
                if (okHttpClient == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor("TNet");
                    loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
                    loggingInterceptor.setColorLevel(Level.INFO);
                    builder.addInterceptor(loggingInterceptor);
                    builder.readTimeout(ClientBuilder.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
                    builder.writeTimeout(ClientBuilder.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
                    builder.connectTimeout(ClientBuilder.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);

                    HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory();
                    builder.sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager);
                    builder.hostnameVerifier(HttpsUtils.UnSafeHostnameVerifier);
                    okHttpClient = builder.build();
                }
                return okHttpClient;
            }
        }
        return okHttpClient;
    }

}
