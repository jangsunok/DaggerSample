package jang.sunok.daggersample;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import jang.sunok.daggersample.di.Injector;

/**
 * Created by jangsunok on 2017. 11. 02.
 */

public class MyApplication extends Application{


    @Override
    public void onCreate() {
        super.onCreate();
        initRealm();
        initDagger();
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

}
