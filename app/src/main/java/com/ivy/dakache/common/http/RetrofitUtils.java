package com.ivy.dakache.common.http;

import com.ivy.common.log.LogUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;


/**
 * Created by fangxiao on 16/1/5.
 */
public class RetrofitUtils {
    private static volatile Retrofit singleton;

    public static <T> T createApi(Class<T> clazz) {
        if (singleton == null) {
            synchronized (RetrofitUtils.class) {
                if (singleton == null) {
                    singleton = createRetrofit();
                }
            }
        }
        return singleton.create(clazz);
    }

    public static void resetSingleton() {
        singleton = createRetrofit();
    }

    private static Retrofit createRetrofit() {
        Retrofit.Builder builder = new Retrofit.Builder();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().newBuilder().build();
                        LogUtils.v("-----------request:", request.toString());
                        Response response = chain.proceed(request);
                        return response;
                    }
                }).build();
        builder.baseUrl(Urls.getURL())
                .client(client)
                .addConverterFactory(StringConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        return builder.build();
    }
}
