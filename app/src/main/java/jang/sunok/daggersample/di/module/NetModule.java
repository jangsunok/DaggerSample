package jang.sunok.daggersample.di.module;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jang.sunok.daggersample.BuildConfig;
import jang.sunok.daggersample.MyApplication;
import jang.sunok.daggersample.SharedPreferencesStore;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jangsunok on 2017. 11. 02.
 */


@Module
public class NetModule {
    MyApplication application;


    public NetModule(MyApplication application) {
        this.application = application;

    }


    /*
     *          Interceptor
     */


    @Provides
    @Singleton
    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }



    /*
     *          GsonConverterFactory
     */


    @Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .serializeNulls()
                .create();
    }


    @Provides
    @Singleton
    public GsonConverterFactory provideGsonConverterFactory(Gson gson) {
        GsonConverterFactory jacksonConverterFactory = GsonConverterFactory.create(gson);
        return jacksonConverterFactory;
    }




    /*
     *          Retrofit
     */


    @Provides
    @Singleton
    public Retrofit provideRetrofit(HttpLoggingInterceptor httpLoggingInterceptor,
                                    GsonConverterFactory gsonConverterFactory,
                                    SharedPreferencesStore sharedPreferencesStore) {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);

        if (BuildConfig.DEBUG) {
            clientBuilder.addInterceptor(httpLoggingInterceptor);
        }

        OkHttpClient client = clientBuilder.build();

        return new Retrofit.Builder()
                .baseUrl("${your_base_url}")
                .client(client)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}
