package jang.sunok.daggersample.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import jang.sunok.daggersample.MyApplication;
import jang.sunok.daggersample.SharedPreferencesStore;

/**
 * Created by jangsunok on 2017. 11. 02.
 */

@Module
public class ApplicationModule {

    private final MyApplication application;

    public ApplicationModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public MyApplication application() {
        return application;
    }

    @Provides
    @Singleton
    public Context applicationContext() {
        return application.getApplicationContext();
    }


    @Provides
    @Singleton
    public Realm provideRealmInstance() {
        return Realm.getDefaultInstance();
    }


    @Provides
    @Singleton
    public SharedPreferencesStore provideSharedPreferences() {
        return new SharedPreferencesStore(application);
    }


}
