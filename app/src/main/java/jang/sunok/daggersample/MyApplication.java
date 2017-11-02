package jang.sunok.daggersample;

import android.app.Application;

import com.google.gson.Gson;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import jang.sunok.daggersample.di.Injector;
import retrofit2.Retrofit;

/**
 * Created by jangsunok on 2017. 11. 02.
 */

public class MyApplication extends Application{
    //Injected by ApplicationModule
    @Inject Realm realm;
    @Inject SharedPreferencesStore sharedPreferencesStore;

    //Injected by NetModule
    @Inject Gson gson;
    @Inject Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        initRealm();
        initDagger();

        //do something you want with Application Component
    }



    protected void initRealm() {
        Realm.init(this);
        RealmConfiguration realmConfiguration
                = new RealmConfiguration.Builder()
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }


    protected void initDagger() {
        Injector.initializeApplicationComponent(this);
        Injector.getApplicationComponent().inject(this);
    }

    public Realm getRealm() {
        return realm;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
